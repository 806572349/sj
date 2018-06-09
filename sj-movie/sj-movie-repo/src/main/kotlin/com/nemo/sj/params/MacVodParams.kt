package com.nemo.sj.params

import java.io.Serializable

/**
 *  create by Nemo
 *  2018/6/8  9:52
 */
class MacVodParams :Serializable{
    private val serialVersionUID = 1L
    /**
     * 影片名称
     */
    var dName: String? = null

    /**
     * 名称拼音首页字母
     */
    var dEnname: String? = null
    /**
     * 年份
     */
    var dYear: Int? = null

    /**
     * 类型
     */
    var dType: Int? = null

    override fun toString(): String {
        return "MacVodParams(serialVersionUID=$serialVersionUID, dName=$dName, dEnname=$dEnname, dYear=$dYear, dType=$dType)"
    }



}