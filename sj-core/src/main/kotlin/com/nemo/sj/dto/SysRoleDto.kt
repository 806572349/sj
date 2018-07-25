package com.nemo.sj.dto

import java.io.Serializable
import java.util.*

/**
 *  create by Nemo
 *  2018/7/25  13:52
 */
class SysRoleDto:Serializable{

    val serialVersionUID=-222

    /**
     * 角色id
     */
    var id: Int? = null
    var name: String? = null
    /**
     * 角色的类型，1：管理员角色，2：其他
     */
    var type: Int? = null
    /**
     * 状态，1：可用，0：冻结
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
     * 最后一次更新的时间
     */
    var operateTime: Date? = null
    /**
     * 最后一次更新者的ip地址
     */
    var operateIp: String? = null




    override fun toString(): String {
        return "SysRole{" +
                ", id=" + id +
                ", name=" + name +
                ", type=" + type +
                ", status=" + status +
                ", remark=" + remark +
                ", operator=" + operator +
                ", operateTime=" + operateTime +
                ", operateIp=" + operateIp +
                "}"
    }
}