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
@TableName("mac_comment")
class MacComment : Model<MacComment>() {

    @TableId(value = "c_id", type = IdType.AUTO)
    var cId: Int? = null
    @TableField("c_type")
    var cType: Int? = null
    @TableField("c_vid")
    var cVid: Int? = null
    @TableField("c_rid")
    var cRid: Int? = null
    @TableField("c_hide")
    var cHide: Int? = null
    @TableField("c_name")
    var cName: String? = null
    @TableField("c_ip")
    var cIp: String? = null
    @TableField("c_content")
    var cContent: String? = null
    @TableField("c_time")
    var cTime: Int? = null


    override fun pkVal(): Serializable? {
        return cId
    }

    override fun toString(): String {
        return "MacComment{" +
        ", cId=" + cId +
        ", cType=" + cType +
        ", cVid=" + cVid +
        ", cRid=" + cRid +
        ", cHide=" + cHide +
        ", cName=" + cName +
        ", cIp=" + cIp +
        ", cContent=" + cContent +
        ", cTime=" + cTime +
        "}"
    }
}
