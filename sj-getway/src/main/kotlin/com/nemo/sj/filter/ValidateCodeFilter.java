/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.nemo.sj.filter;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nemo.sj.common.JsonData;
import com.nemo.sj.config.FilterIgnorePropertiesConfig;
import com.nemo.sj.constant.SecurityConstants;
import com.nemo.sj.exception.ValidateCodeException;
import com.nemo.sj.util.AuthUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author lengleng
 * @date 2018/5/10
 * <p>
 * security.validate.code.enabled 默认 为false，开启需要设置为true
 */
@Slf4j
@RefreshScope
@Configuration("validateCodeFilter")
@ConditionalOnProperty(value = "security.validate.code", havingValue = "true")
public class ValidateCodeFilter extends ZuulFilter {
    private static final String EXPIRED_CAPTCHA_ERROR = "验证码已过期，请重新获取";

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;

    private AntPathMatcher pathMatcher = new AntPathMatcher();


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_ERROR_FILTER_ORDER + 1;
    }

    /**
     * 是否校验验证码
     * 1. 判断验证码开关是否开启
     * 2. 判断请求是否登录请求
     * 3. 判断终端是否支持
     *
     * @return true/false
     */
    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info("是否需要过滤的地址："+request.getRequestURI());

        List<String> imageurls = filterIgnorePropertiesConfig.getIamgeurls();
        for (String smsUrl:imageurls){
            if (pathMatcher.match(smsUrl, request.getRequestURI())&&request.getMethod().equalsIgnoreCase("post")) {
                return true;
            }
        }


        List<String> smsurls = filterIgnorePropertiesConfig.getSmsurls();
        for (String smsUrl:smsurls){
            if (pathMatcher.match(smsUrl, request.getRequestURI())&&request.getMethod().equalsIgnoreCase("post")) {
                return true;
            }
        }

        List<String> hashcodeurls = filterIgnorePropertiesConfig.getHashcodeurls();
        for (String hcUrl:hashcodeurls){
            if (pathMatcher.match(hcUrl, request.getRequestURI())&&request.getMethod().equalsIgnoreCase("post")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object run() {
        try {
            checkCode(RequestContext.getCurrentContext().getRequest());
        } catch (ValidateCodeException e) {
            RequestContext ctx = RequestContext.getCurrentContext();
            JsonData result = new JsonData();
            result.setRet(false);
            result.setMsg(e.getMessage());
            ctx.setResponseStatusCode(478);
            ctx.setSendZuulResponse(false);
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
            ctx.setResponseBody(JSONObject.toJSONString(result));
        }
        return null;
    }

    /**
     * 检查code
     *
     * @param httpServletRequest request
     * @throws ValidateCodeException 验证码校验异常
     */
    private void checkCode(HttpServletRequest httpServletRequest) throws ValidateCodeException {

        String randomStr="";
        String code="";
            code = httpServletRequest.getParameter("systemCode");
            if (StringUtils.isBlank(code)) {
                throw new ValidateCodeException("请输入验证码");
            }
            randomStr= httpServletRequest.getParameter("randomStr");
            if (StringUtils.isBlank(randomStr)){
                throw new ValidateCodeException("请输入randomStr");
            }

        String key = SecurityConstants.DEFAULT_CODE_KEY + randomStr;
        if (!redisTemplate.hasKey(key)) {
            throw new ValidateCodeException(EXPIRED_CAPTCHA_ERROR);
        }

        Object codeObj = redisTemplate.opsForValue().get(key);

        if (codeObj == null) {
            throw new ValidateCodeException(EXPIRED_CAPTCHA_ERROR);
        }

        String saveCode = codeObj.toString();
        if (StringUtils.isBlank(saveCode)) {
            redisTemplate.delete(key);
            throw new ValidateCodeException(EXPIRED_CAPTCHA_ERROR);
        }

        if (!StringUtils.equals(saveCode, code)) {
            redisTemplate.delete(key);
            throw new ValidateCodeException("验证码错误，请重新输入");
        }

        redisTemplate.delete(key);
    }


}
