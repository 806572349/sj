package com.nemo.sj.system.service;

import com.nemo.sj.system.entity.SysAcl;
import com.baomidou.mybatisplus.service.IService;
import com.nemo.sj.system.entity.SysRoleAcl

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
interface ISysAclService : IService<SysAcl> {
    /**
     *  根据角色名 查询模块列表
     */
    fun findAclByRoleName(roleName: String): List<SysRoleAcl>
}
