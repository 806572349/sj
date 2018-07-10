package com.nemo.sj.system.entity

import com.baomidou.mybatisplus.enums.IdType
import java.util.Date
import com.baomidou.mybatisplus.annotations.TableId
import com.baomidou.mybatisplus.annotations.TableField
import com.baomidou.mybatisplus.activerecord.Model
import com.baomidou.mybatisplus.annotations.TableName
import java.io.Serializable

/**
 * <p>
 * 
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
@TableName("sys_role_acl")
class SysRoleAcl : Model<SysRoleAcl>() {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null
    /**
     * 角色id
     */
    @TableField("role_id")
    var roleId: Int? = null
    /**
     * 权限id
     */
    @TableField("acl_id")
    var aclId: Int? = null
    /**
     * 操作者
     */
    var operator: String? = null
    /**
     * 最后一次更新的时间
     */
    @TableField("operate_time")
    var operateTime: Date? = null
    /**
     * 最后一次更新者的ip
     */
    @TableField("operate_ip")
    var operateIp: String? = null


    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysRoleAcl{" +
        ", id=" + id +
        ", roleId=" + roleId +
        ", aclId=" + aclId +
        ", operator=" + operator +
        ", operateTime=" + operateTime +
        ", operateIp=" + operateIp +
        "}"
    }
}
