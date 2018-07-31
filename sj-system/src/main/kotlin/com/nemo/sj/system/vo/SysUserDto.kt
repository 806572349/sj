package com.nemo.sj.system.vo

import com.nemo.sj.system.common.util.Converter
import com.nemo.sj.system.entity.SysRole
import com.nemo.sj.system.entity.SysUser
import org.springframework.beans.BeanUtils
import java.util.*

/**
 *  create by Nemo
 *  2018/7/24  14:07
 */
class SysUserDto {


    var status: Int? = null
    var id:Int?=null
    /**
     * 用户名
     */
    var username:String?=null

    /**
     * 密码
     */
    var password:String?=null

    /**
     * 手机号
     */
    var telephone: String? = null

    /**
     * 邮箱
     */
    var mail: String? = null


    var operateIp: String? = null

    /**
     * 部门名称
     */
    var deptName: String? = null


    /**
     * 部门id
     */
    var deptId: Int? = null

    /**
     * 角色
     */
    var roleList:List<SysRole>?=null


    var operateTime: Date? = null
    /**
     * 静态方法
     */
    companion object : Converter<SysUserDto, SysUser> {

         override  fun doForward(userInputDTO: SysUserDto): SysUser {
            val user = SysUser()
            BeanUtils.copyProperties(userInputDTO, user)
            return user
        }
        override fun doBackward(user: SysUser): SysUserDto {
            val userInputDTO = SysUserDto()
            BeanUtils.copyProperties(user, userInputDTO)
            return userInputDTO
        }
    }
}