package com.nemo.sj.dto

import java.io.Serializable
import java.util.*

/**
 *  create by Nemo
 *  2018/7/25  13:55
 */
class UserDto {


    /**
     * 用户id
     */
    var id: Int? = null
    /**
     * 用户名称
     */
    var username: String? = null
    /**
     * 手机号
     */
    var telephone: String? = null
    /**
     * 邮箱
     */
    var mail: String? = null
    /**
     * 加密后的密码
     */
    var password: String? = null
    /**
     * 用户所在部门的id
     */
    var deptId: Int? = null
    /**
     * 状态，1：正常，0：冻结状态，2：删除
     */
    var status: Int? = null
    /**
     * 备注
     */
    var remark: String? = null
    /**
     * 操作者
     */
    var operator: String? = null
    /**
     * 最后一次更新时间
     */
    var operateTime: Date? = null
    /**
     * 最后一次更新者的ip地址
     */
    var operateIp: String? = null


    /**
     * 角色列表
     */
     var roleList: List<SysRoleDto>? = null

    override fun toString(): String {
        return "SysUser{" +
                ", id=" + id +
                ", username=" + username +
                ", telephone=" + telephone +
                ", mail=" + mail +
                ", password=" + password +
                ", deptId=" + deptId +
                ", status=" + status +
                ", remark=" + remark +
                ", operator=" + operator +
                ", operateTime=" + operateTime +
                ", operateIp=" + operateIp +
                "}"
    }
}