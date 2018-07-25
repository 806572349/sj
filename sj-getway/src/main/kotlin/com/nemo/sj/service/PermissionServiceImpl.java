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

package com.nemo.sj.service;


import com.nemo.sj.dto.AclDto;
import com.nemo.sj.fegin.AclService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lengleng
 * @date 2017/10/28
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private AclService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //ele-admin options 跨域配置，现在处理是通过前端配置代理，不使用这种方式，存在风险
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
//            return true;
//        }
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtils.isEmpty(grantedAuthorityList)) {
                log.warn("角色列表为空：{}", authentication.getPrincipal());
                return hasPermission;
            }

            List<AclDto> urls = new ArrayList<>();
            for (SimpleGrantedAuthority authority : grantedAuthorityList) {
                if (!StringUtils.equals(authority.getAuthority(), "ROLE_USER")) {
                    List<AclDto> menuVOSet = menuService.findAclByRoleName(authority.getAuthority());
                    if (!CollectionUtils.isEmpty(menuVOSet)) {
                        urls.addAll(menuVOSet);
                    }
                }
            }

            for (AclDto menu : urls) {
                String url = menu.getUrl();
                String requestURI = request.getRequestURI();
                log.info("url:{},requestURI:{} ",url,requestURI);
                if (StringUtils.isNotEmpty(menu.getUrl()) && antPathMatcher.match(menu.getUrl(), request.getRequestURI())
                        && request.getMethod().equalsIgnoreCase(menu.getMethod())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
