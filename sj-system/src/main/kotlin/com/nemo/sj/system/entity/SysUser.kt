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
@TableName("sys_user")
class SysUser : Model<SysUser>() {

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    @TableField("dept_id")
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
