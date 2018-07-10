package com.nemo.sj.system.web;


import com.nemo.sj.system.service.ISysUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
@RestController
@RequestMapping("/system/sysUser")
class SysUserController{
    @Autowired
    lateinit var isysUserService: ISysUserService


    @GetMapping
    fun void():String {
        return "test";
    }

}
