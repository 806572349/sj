package com.nemo.sj.system.service;

import com.nemo.sj.system.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
interface ISysRoleService : IService<SysRole> {
    /**
     * 根据角色名称查找 角色信息
     */
    fun findByRoleName(roleName: String): SysRole
}
