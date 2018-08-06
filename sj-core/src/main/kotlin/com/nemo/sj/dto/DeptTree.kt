package com.nemo.sj.dto

import java.util.*

/**
 *  create by Nemo
 *  2018/8/5  17:30
 */
open class DeptTree :TreeNode() {

    /**
     * 部门id
     */
    /**
     * 部门名称
     */
    var name: String? = null

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
    var operateTime: Date? = null
    /**
     * 最后一次更新操作者的ip地址
     */
    var operateIp: String? = null
}