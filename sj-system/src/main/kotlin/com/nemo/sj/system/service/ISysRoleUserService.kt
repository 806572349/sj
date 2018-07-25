package com.nemo.sj.system.service;

import com.nemo.sj.system.entity.SysRoleUser;
import com.baomidou.mybatisplus.service.IService;
import com.nemo.sj.system.entity.SysRole

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
interface ISysRoleUserService : IService<SysRoleUser> {
    /**
     * 通过用户id 查询角色列表
     */
    fun findRoleListByUserId(userId: Int?): List<SysRole>
}
