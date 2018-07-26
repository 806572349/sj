package com.nemo.sj.system.service;

import com.nemo.sj.system.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;
import com.nemo.sj.common.JsonData

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
interface ISysUserService : IService<SysUser> {
    /**
     * 登陆
     */
    fun login(user: SysUser): SysUser?

    /**
     * 通过部门id  用户列表
     * @param depId 部门id
     */
    fun findByDepIdList(depId: Int): List<SysUser>

    fun saveImageCode(randomStr: String, text: String)
    fun saveHashCode(): JsonData
}
