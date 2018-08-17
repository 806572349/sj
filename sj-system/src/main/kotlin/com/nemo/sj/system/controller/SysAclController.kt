package com.nemo.sj.system.controller;


import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.dto.AclDto
import com.nemo.sj.dto.SysAclTree
import com.nemo.sj.system.entity.SysAcl
import com.nemo.sj.system.entity.SysRoleAcl
import com.nemo.sj.system.service.ISysAclService
import com.nemo.sj.system.service.ISysUserService
import com.nemo.sj.system.vo.SysAclVo
import org.apache.coyote.http11.Constants.a
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors
import javax.validation.Valid

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
        val data = aclList.stream().filter { a -> a != null }.map { a ->
            var dto = AclDto()
            BeanUtils.copyProperties(a, dto)
            dto
        }.collect(Collectors.toList())
        return   data
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
    fun findByPage(page: Page<SysAcl>,type:Int?,status:Int?):Page<SysAcl>{
        return iSysAclService.findByPage(page,type,status)
    }

    /**
     * 通过id 查询模块
     */
    @GetMapping("/page/{id}")
    fun  findById(@PathVariable id:Int):SysAcl{
        return iSysAclService.selectById(id)
    }
    /**
     * 更新模块
     */
    @PostMapping("/update")
    fun  updateAcl(@Valid sysAcl: SysAclVo):SysAcl{
       return iSysAclService.updateAcl(sysAcl)
    }

}
