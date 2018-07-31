package com.nemo.sj.system.controller;


import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.dto.AclDto
import com.nemo.sj.dto.SysAclTree
import com.nemo.sj.system.entity.SysAcl
import com.nemo.sj.system.entity.SysRoleAcl
import com.nemo.sj.system.service.ISysAclService
import com.nemo.sj.system.service.ISysUserService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

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
    @GetMapping("/findAclByRoleName/{roleName}")
    fun findAclByRoleName(@PathVariable roleName:String):List<AclDto>{
        val aclList = iSysAclService.findAclByRoleName(roleName)
        return  aclList.stream().map { a->
            var dto=AclDto()
            BeanUtils.copyProperties(a,dto)
            dto
        }.collect(Collectors.toList())
    }
    /**
     * 通过用户id  查询模块
     * @param uid  用户id
     */
    @GetMapping("/findAclByUserId/{uid}")
    fun findAclByRoleName(@PathVariable uid:Int):List<SysAclTree>?{
        return iSysAclService.findByAclByUserId(uid)
    }

    /**
     * 查询模块列表
     */
    @GetMapping("/page")
    fun findByPage(page: Page<SysAcl>):Page<SysAcl>{
        return iSysAclService.selectPage(page)
    }

}
