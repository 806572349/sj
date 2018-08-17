package com.nemo.sj.system.service;

import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.system.entity.SysAcl;
import com.baomidou.mybatisplus.service.IService;
import com.nemo.sj.dto.SysAclTree
import com.nemo.sj.system.entity.SysRoleAcl
import com.nemo.sj.system.vo.SysAclVo

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
    fun findAclByRoleName(roleName: String): List<SysAcl>

    /**
     * 通过用户id  查询模块
     * @param uid  用户id
     */
    fun findByAclByUserId(uid: Int): List<SysAclTree>?

    fun findByPage(page: Page<SysAcl>, type: Int?, status: Int?): Page<SysAcl>
    /**
     * 更新模块
     */
    fun updateAcl(sysAclVo: SysAclVo): SysAcl
}
