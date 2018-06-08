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
@TableName("mac_art_relation")
class MacArtRelation : Model<MacArtRelation>() {

    @TableId(value = "r_id", type = IdType.AUTO)
    var rId: Int? = null
    @TableField("r_type")
    var rType: Int? = null
    @TableField("r_a")
    var rA: Int? = null
    @TableField("r_b")
    var rB: Int? = null


    override fun pkVal(): Serializable? {
        return rId
    }

    override fun toString(): String {
        return "MacArtRelation{" +
        ", rId=" + rId +
        ", rType=" + rType +
        ", rA=" + rA +
        ", rB=" + rB +
        "}"
    }
}
