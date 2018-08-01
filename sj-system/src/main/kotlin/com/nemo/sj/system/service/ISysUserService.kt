package com.nemo.sj.system.service;

import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.system.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;
import com.nemo.sj.common.JsonData
import com.nemo.sj.system.vo.SysUserDto
import java.util.*

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

    /**
     * 用户查询分页
     */
    fun findUserListPage(page: Page<SysUser>, user: SysUserDto, startTime: Date?, endTime: Date?): Page<SysUserDto>?
}
