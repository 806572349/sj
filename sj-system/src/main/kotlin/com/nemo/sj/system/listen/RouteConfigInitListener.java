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

package com.nemo.sj.system.listen;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.nemo.sj.constant.CommonConstant;
import com.nemo.sj.dto.SysZuulRouteDto;
import com.nemo.sj.system.entity.SysZuulRoute;
import com.nemo.sj.system.service.ISysZuulRouteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lengleng
 * @date 2018/5/16
 */
@Slf4j
@Component
public class RouteConfigInitListener {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ISysZuulRouteService sysZuulRouteService;

    /**
     * Callback used to run the bean.
     * 初始化路由配置的数据，避免gateway 依赖业务模块
     *
     */
    @EventListener(value = {EmbeddedServletContainerInitializedEvent.class})
    public void init() {
        log.info("开始初始化路由配置数据");
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        List<SysZuulRoute> routeList = sysZuulRouteService.selectList(wrapper);


        if (CollectionUtils.isNotEmpty(routeList)) {
            List<SysZuulRouteDto> collect = routeList.stream().map(a -> {
                SysZuulRouteDto sysZuulRouteDto = new SysZuulRouteDto();
                BeanUtils.copyProperties(a, sysZuulRouteDto);
                return sysZuulRouteDto;
            }).collect(Collectors.toList());

            redisTemplate.opsForValue().set(CommonConstant.ROUTE_KEY, collect);
            log.info("更新Redis中路由配置数据：{}条", routeList.size());
        }
        log.info("初始化路由配置数据完毕");
    }
}