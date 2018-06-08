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
@TableName("mac_user")
class MacUser : Model<MacUser>() {

    @TableId(value = "u_id", type = IdType.AUTO)
    var uId: Int? = null
    @TableField("u_qid")
    var uQid: String? = null
    @TableField("u_name")
    var uName: String? = null
    @TableField("u_password")
    var uPassword: String? = null
    @TableField("u_qq")
    var uQq: String? = null
    @TableField("u_email")
    var uEmail: String? = null
    @TableField("u_phone")
    var uPhone: String? = null
    @TableField("u_status")
    var uStatus: Int? = null
    @TableField("u_flag")
    var uFlag: Int? = null
    @TableField("u_question")
    var uQuestion: String? = null
    @TableField("u_answer")
    var uAnswer: String? = null
    @TableField("u_group")
    var uGroup: Int? = null
    @TableField("u_points")
    var uPoints: Int? = null
    @TableField("u_regtime")
    var uRegtime: Int? = null
    @TableField("u_logintime")
    var uLogintime: Int? = null
    @TableField("u_loginnum")
    var uLoginnum: Int? = null
    @TableField("u_extend")
    var uExtend: Int? = null
    @TableField("u_loginip")
    var uLoginip: Int? = null
    @TableField("u_random")
    var uRandom: String? = null
    @TableField("u_fav")
    var uFav: String? = null
    @TableField("u_plays")
    var uPlays: String? = null
    @TableField("u_downs")
    var uDowns: String? = null
    @TableField("u_start")
    var uStart: Int? = null
    @TableField("u_end")
    var uEnd: Int? = null


    override fun pkVal(): Serializable? {
        return uId
    }

    override fun toString(): String {
        return "MacUser{" +
        ", uId=" + uId +
        ", uQid=" + uQid +
        ", uName=" + uName +
        ", uPassword=" + uPassword +
        ", uQq=" + uQq +
        ", uEmail=" + uEmail +
        ", uPhone=" + uPhone +
        ", uStatus=" + uStatus +
        ", uFlag=" + uFlag +
        ", uQuestion=" + uQuestion +
        ", uAnswer=" + uAnswer +
        ", uGroup=" + uGroup +
        ", uPoints=" + uPoints +
        ", uRegtime=" + uRegtime +
        ", uLogintime=" + uLogintime +
        ", uLoginnum=" + uLoginnum +
        ", uExtend=" + uExtend +
        ", uLoginip=" + uLoginip +
        ", uRandom=" + uRandom +
        ", uFav=" + uFav +
        ", uPlays=" + uPlays +
        ", uDowns=" + uDowns +
        ", uStart=" + uStart +
        ", uEnd=" + uEnd +
        "}"
    }
}
