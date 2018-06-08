package com.nemo.sj.entity

import com.baomidou.mybatisplus.annotations.TableField
import com.baomidou.mybatisplus.activerecord.Model
import java.io.Serializable

/**
 * <p>
 * 
 * </p>
 *
 * @author nemo
 * @since 2018-06-08
 */
class Tmptable : Model<Tmptable>() {

    @TableField("a_name1")
    var aName1: String? = null


    override fun pkVal(): Serializable? {
        return null
    }

    override fun toString(): String {
        return "Tmptable{" +
        ", aName1=" + aName1 +
        "}"
    }
}
