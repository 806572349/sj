package com.nemo.sj.system.dao

import com.baomidou.mybatisplus.mapper.Condition
import com.nemo.mp.base.BaseDao
import com.nemo.sj.system.entity.SysUser
import com.nemo.sj.system.mapper.SysUserMapper
import org.springframework.stereotype.Repository
import javax.annotation.Resource

/**
 *  create by Nemo
 *  2018/7/24  11:56
 */
@Repository
class SysUserDao : BaseDao() {

    @Resource
    lateinit var userMapper: SysUserMapper

    fun  queryone(user: SysUser): SysUser?{
        val wrapper = Condition.wrapper<SysUser>()
        wrapper.eq("username",user.username)

        val sysUser = userMapper.selectList(wrapper)
        return  if (sysUser.size>0) sysUser.get(0) else null
    }

    fun queryListByDepId(user: SysUser):List<SysUser>{
        val wrapper = Condition.wrapper<SysUser>()
        if (user.deptId!=null){
            wrapper.eq("dept_id",user.deptId)
        }
        return userMapper.selectList(wrapper)
    }



}