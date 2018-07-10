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
@TableName("sys_role")
class SysRole : Model<SysRole>() {

    /**
     * 角色id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    @TableField("operate_time")
    var operateTime: Date? = null
    /**
     * 最后一次更新者的ip地址
     */
    @TableField("operate_ip")
    var operateIp: String? = null


    override fun pkVal(): Serializable? {
        return id
    }

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
