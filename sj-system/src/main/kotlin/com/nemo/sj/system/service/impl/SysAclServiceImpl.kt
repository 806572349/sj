package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysAcl;
import com.nemo.sj.system.mapper.SysAclMapper;
import com.nemo.sj.system.service.ISysAclService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.system.entity.SysRoleAcl
import com.nemo.sj.system.service.ISysRoleAclService
import com.nemo.sj.system.service.ISysRoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
import javax.annotation.Resource

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
@Service
open class SysAclServiceImpl : ServiceImpl<SysAclMapper, SysAcl>(), ISysAclService {

    @Resource
    lateinit var sysAclMapper: SysAclMapper

    @Autowired
    lateinit var iSysRoleService: ISysRoleService

    @Autowired
    lateinit var iSysRoleAclService: ISysRoleAclService

    /**
     *  根据角色名 查询模块列表
     */
    override fun findAclByRoleName(roleName:String):List<SysRoleAcl>{
        //获取角色信息
        val sysRole = iSysRoleService.findByRoleName(roleName)
        // 获取该角色下的模块信息
       return iSysRoleAclService.findAclByRoleId(sysRole.id)
    }

}
