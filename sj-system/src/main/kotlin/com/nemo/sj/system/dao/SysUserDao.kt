package com.nemo.sj.system.dao

import com.baomidou.mybatisplus.mapper.Condition
import com.baomidou.mybatisplus.plugins.Page
import com.nemo.mp.base.BaseDao
import com.nemo.sj.system.entity.SysUser
import com.nemo.sj.system.mapper.SysUserMapper
import com.nemo.sj.system.vo.SysUserDto
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Repository
import java.util.*
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


    fun  findUserListPage(page: Page<SysUser>, user: SysUserDto, startTime: Date?, endTime: Date?): Page<SysUser>? {
        val entityWrapper = Condition.wrapper<SysUser>()
        if (user.id!=null)entityWrapper.eq("id",user.id)
        if (StringUtils.isNotBlank(user.mail))entityWrapper.eq("mail",user.mail)
        if (StringUtils.isNotBlank(user.username))entityWrapper.eq("username",user.username)
        if (StringUtils.isNotBlank(user.telephone))entityWrapper.eq("telephone",user.telephone)
        if (startTime!=null) entityWrapper.ge("operate_time",startTime)
        if (startTime!=null) entityWrapper.ge("operate_time",startTime)

        if (user.status!=null)entityWrapper.eq("status",user.status)
        page.records=userMapper.selectPage(page, entityWrapper)
        return page
    }


}