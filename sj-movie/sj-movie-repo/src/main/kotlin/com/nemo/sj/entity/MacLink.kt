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
@TableName("mac_link")
class MacLink : Model<MacLink>() {

    @TableId(value = "l_id", type = IdType.AUTO)
    var lId: Int? = null
    @TableField("l_name")
    var lName: String? = null
    @TableField("l_url")
    var lUrl: String? = null
    @TableField("l_logo")
    var lLogo: String? = null
    @TableField("l_type")
    var lType: Int? = null
    @TableField("l_sort")
    var lSort: Int? = null


    override fun pkVal(): Serializable? {
        return lId
    }

    override fun toString(): String {
        return "MacLink{" +
        ", lId=" + lId +
        ", lName=" + lName +
        ", lUrl=" + lUrl +
        ", lLogo=" + lLogo +
        ", lType=" + lType +
        ", lSort=" + lSort +
        "}"
    }
}
