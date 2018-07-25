package com.nemo.sj.system.controller;


import com.nemo.sj.system.entity.SysRoleAcl
import com.nemo.sj.system.service.ISysAclService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/system/sysAcl")
class SysAclController{


    @Autowired
    lateinit var iSysAclService: ISysAclService

    /**
     *  根据角色名 查询模块列表
     */
    @PostMapping("/findAclByRoleName/{roleName}")
    fun findAclByRoleName(@PathVariable roleName:String):List<SysRoleAcl>{
        return iSysAclService.findAclByRoleName(roleName)
    }

}
