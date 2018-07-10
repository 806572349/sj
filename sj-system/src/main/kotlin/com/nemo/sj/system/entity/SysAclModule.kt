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
@TableName("sys_acl_module")
class SysAclModule : Model<SysAclModule>() {

    /**
     * 权限模块id
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null
    /**
     * 权限模块名称
     */
    var name: String? = null
    /**
     * 上级权限模块id
     */
    @TableField("parent_id")
    var parentId: Int? = null
    /**
     * 权限模块层级
     */
    var level: String? = null
    /**
     * 权限模块在当前层级下的顺序，由小到大
     */
    var seq: Int? = null
    /**
     * 状态，1：正常，0：冻结
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
     * 最后一次操作时间
     */
    @TableField("operate_time")
    var operateTime: Date? = null
    /**
     * 最后一次更新操作者的ip地址
     */
    @TableField("operate_ip")
    var operateIp: String? = null


    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysAclModule{" +
        ", id=" + id +
        ", name=" + name +
        ", parentId=" + parentId +
        ", level=" + level +
        ", seq=" + seq +
        ", status=" + status +
        ", remark=" + remark +
        ", operator=" + operator +
        ", operateTime=" + operateTime +
        ", operateIp=" + operateIp +
        "}"
    }
}
