package com.nemo.sj.system.dao

import com.baomidou.mybatisplus.mapper.Condition
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
        val wrapper = Condition.wrapper<SysRole>()
        wrapper.eq("name",role.name)
        val list = sysRoleMapper.selectList(wrapper)
        return if (list.size>0) list.get(0) else  SysRole()
    }

}