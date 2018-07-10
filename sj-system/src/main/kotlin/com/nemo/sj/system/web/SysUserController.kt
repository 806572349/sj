package com.nemo.sj.system.web;


import com.nemo.sj.common.JsonData
import com.nemo.sj.exception.PermissionException
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

    lateinit var  data:JsonData
    @GetMapping
    fun void():JsonData {
        throw PermissionException("这是异常")

        return JsonData.Companion.success("test")
    }

}
