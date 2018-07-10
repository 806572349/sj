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
@TableName("sys_acl")
class SysAcl : Model<SysAcl>() {

    /**
     * 权限id
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null
    /**
     * 权限码
     */
    var code: String? = null
    /**
     * 权限名称
     */
    var name: String? = null
    /**
     * 权限所在的权限模块id
     */
    @TableField("acl_module_id")
    var aclModuleId: Int? = null
    /**
     * 请求的url, 可以填正则表达式
     */
    var url: String? = null
    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    var type: Int? = null
    /**
     * 状态，1：正常，0：冻结
     */
    var status: Int? = null
    /**
     * 权限在当前模块下的顺序，由小到大
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
     * 最后一次更新时间
     */
    @TableField("operate_time")
    var operateTime: Date? = null
    /**
     * 最后一个更新者的ip地址
     */
    @TableField("operate_ip")
    var operateIp: String? = null


    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysAcl{" +
        ", id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", aclModuleId=" + aclModuleId +
        ", url=" + url +
        ", type=" + type +
        ", status=" + status +
        ", seq=" + seq +
        ", remark=" + remark +
        ", operator=" + operator +
        ", operateTime=" + operateTime +
        ", operateIp=" + operateIp +
        "}"
    }
}
