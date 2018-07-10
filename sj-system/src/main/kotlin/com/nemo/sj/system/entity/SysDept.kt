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
@TableName("sys_dept")
class SysDept : Model<SysDept>() {

    /**
     * 部门id
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null
    /**
     * 部门名称
     */
    var name: String? = null
    /**
     * 上级部门id
     */
    @TableField("parent_id")
    var parentId: Int? = null
    /**
     * 部门层级
     */
    var level: String? = null
    /**
     * 部门在当前层级下的顺序，由小到大
     */
    var seq: Int? = null
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
        return "SysDept{" +
        ", id=" + id +
        ", name=" + name +
        ", parentId=" + parentId +
        ", level=" + level +
        ", seq=" + seq +
        ", remark=" + remark +
        ", operator=" + operator +
        ", operateTime=" + operateTime +
        ", operateIp=" + operateIp +
        "}"
    }
}
