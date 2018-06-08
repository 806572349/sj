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
@TableName("mac_user_group")
class MacUserGroup : Model<MacUserGroup>() {

    @TableId(value = "ug_id", type = IdType.AUTO)
    var ugId: Int? = null
    @TableField("ug_name")
    var ugName: String? = null
    @TableField("ug_type")
    var ugType: String? = null
    @TableField("ug_popedom")
    var ugPopedom: String? = null
    @TableField("ug_upgrade")
    var ugUpgrade: Int? = null
    @TableField("ug_popvalue")
    var ugPopvalue: Int? = null


    override fun pkVal(): Serializable? {
        return ugId
    }

    override fun toString(): String {
        return "MacUserGroup{" +
        ", ugId=" + ugId +
        ", ugName=" + ugName +
        ", ugType=" + ugType +
        ", ugPopedom=" + ugPopedom +
        ", ugUpgrade=" + ugUpgrade +
        ", ugPopvalue=" + ugPopvalue +
        "}"
    }
}
