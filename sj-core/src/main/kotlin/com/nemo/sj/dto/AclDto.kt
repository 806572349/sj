package com.nemo.sj.dto

import java.util.*

/**
 *  create by Nemo
 *  2018/7/25  21:18
 */
class AclDto {

    /**
     * 权限id
     */
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
    var operateTime: Date? = null
    /**
     * 最后一个更新者的ip地址
     */
    var operateIp: String? = null

    /**
     * 前端路径
     */
    var path: String? = null
    /**
     * 请求方法
     */
    var method: String? = null

    /**
     * 图标
     */
    var icon: String? = null
    /**
     * vue 界面
     */
    var component: String? = null

    var parentId:Int?=null
}