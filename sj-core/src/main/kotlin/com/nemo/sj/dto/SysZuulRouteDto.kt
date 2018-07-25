package com.nemo.sj.dto

import org.springframework.ui.Model
import java.io.Serializable
import java.util.*

/**
 *  create by Nemo
 *  2018/7/25  10:42
 */
class SysZuulRouteDto :Serializable {

    /**
     * router Id
     */
    var id: Int? = null
    /**
     * 路由路径
     */
    var path: String? = null
    /**
     * 服务名称
     */
    var serviceId: String? = null
    /**
     * url代理
     */
    var url: String? = null
    /**
     * 转发去掉前缀
     */
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
    var sensitiveheadersList: String? = null
    /**
     * 创建时间
     */
    var createTime: Date? = null
    /**
     * 更新时间
     */
    var updateTime: Date? = null
    /**
     * 删除标识（0-正常,1-删除）
     */
    var delFlag: String? = null




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