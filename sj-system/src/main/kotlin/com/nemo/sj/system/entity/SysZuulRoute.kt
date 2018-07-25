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
 * 动态路由配置表
 * </p>
 *
 * @author nemo
 * @since 2018-07-25
 */
@TableName("sys_zuul_route")
class SysZuulRoute : Model<SysZuulRoute>(),Serializable {

    /**
     * router Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null
    /**
     * 路由路径
     */
    var path: String? = null
    /**
     * 服务名称
     */
    @TableField("service_id")
    var serviceId: String? = null
    /**
     * url代理
     */
    var url: String? = null
    /**
     * 转发去掉前缀
     */
    @TableField("strip_prefix")
    var stripPrefix: String? = null
    /**
     * 是否重试
     */
    var retryable: String? = null
    /**
     * 是否启用
     */
    var enabled: String? = null
    /**
     * 敏感请求头
     */
    @TableField("sensitiveHeaders_list")
    var sensitiveheadersList: String? = null
    /**
     * 创建时间
     */
    @TableField("create_time")
    var createTime: Date? = null
    /**
     * 更新时间
     */
    @TableField("update_time")
    var updateTime: Date? = null
    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableField("del_flag")
    var delFlag: String? = null


    override fun pkVal(): Serializable? {
        return id
    }

    override fun toString(): String {
        return "SysZuulRoute{" +
        ", id=" + id +
        ", path=" + path +
        ", serviceId=" + serviceId +
        ", url=" + url +
        ", stripPrefix=" + stripPrefix +
        ", retryable=" + retryable +
        ", enabled=" + enabled +
        ", sensitiveheadersList=" + sensitiveheadersList +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", delFlag=" + delFlag +
        "}"
    }
}
