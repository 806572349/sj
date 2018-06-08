package com.nemo.sj.entity

import com.baomidou.mybatisplus.enums.IdType
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
 * @since 2018-06-08
 */
@TableName("mac_gbook")
class MacGbook : Model<MacGbook>() {

    @TableId(value = "g_id", type = IdType.AUTO)
    var gId: Int? = null
    @TableField("g_vid")
    var gVid: Int? = null
    @TableField("g_hide")
    var gHide: Int? = null
    @TableField("g_sort")
    var gSort: Int? = null
    @TableField("g_name")
    var gName: String? = null
    @TableField("g_content")
    var gContent: String? = null
    @TableField("g_reply")
    var gReply: String? = null
    @TableField("g_ip")
    var gIp: Int? = null
    @TableField("g_time")
    var gTime: Int? = null
    @TableField("g_replytime")
    var gReplytime: Int? = null


    override fun pkVal(): Serializable? {
        return gId
    }

    override fun toString(): String {
        return "MacGbook{" +
        ", gId=" + gId +
        ", gVid=" + gVid +
        ", gHide=" + gHide +
        ", gSort=" + gSort +
        ", gName=" + gName +
        ", gContent=" + gContent +
        ", gReply=" + gReply +
        ", gIp=" + gIp +
        ", gTime=" + gTime +
        ", gReplytime=" + gReplytime +
        "}"
    }
}
