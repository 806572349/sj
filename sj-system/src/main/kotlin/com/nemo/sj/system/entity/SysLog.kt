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
@TableName("sys_log")
class SysLog : Model<SysLog>() {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null
    /**
     * 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     */
    var type: Int? = null
    /**
     * 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    @TableField("target_id")
    var targetId: Int? = null
    /**
     * 旧值
     */
    @TableField("old_value")
    var oldValue: String? = null
    /**
     * 新值
     */
    @TableField("new_value")
    var newValue: String? = null
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
    /**
     * 当前是否复原过，0：没有，1：复原过
     */
    var status: Int? = null


    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysLog{" +
        ", id=" + id +
        ", type=" + type +
        ", targetId=" + targetId +
        ", oldValue=" + oldValue +
        ", newValue=" + newValue +
        ", operator=" + operator +
        ", operateTime=" + operateTime +
        ", operateIp=" + operateIp +
        ", status=" + status +
        "}"
    }
}
