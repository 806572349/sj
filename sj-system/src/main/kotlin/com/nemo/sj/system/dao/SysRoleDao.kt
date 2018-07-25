package com.nemo.sj.system.dao

import com.nemo.mp.base.BaseDao
import com.nemo.sj.system.entity.SysRole
import com.nemo.sj.system.mapper.SysRoleMapper
import org.springframework.stereotype.Repository
import javax.annotation.Resource

/**
 *  create by Nemo
 *  2018/7/25  21:35
 */
@Repository
class SysRoleDao :BaseDao() {

    @Resource
    lateinit var sysRoleMapper: SysRoleMapper;

    fun  findOne(role: SysRole):SysRole{
        return sysRoleMapper.selectOne(role)
    }

}