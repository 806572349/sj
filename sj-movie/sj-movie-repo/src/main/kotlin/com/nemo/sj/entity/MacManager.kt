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
@TableName("mac_manager")
class MacManager : Model<MacManager>() {

    @TableId(value = "m_id", type = IdType.AUTO)
    var mId: Int? = null
    @TableField("m_name")
    var mName: String? = null
    @TableField("m_password")
    var mPassword: String? = null
    @TableField("m_levels")
    var mLevels: String? = null
    @TableField("m_random")
    var mRandom: String? = null
    @TableField("m_status")
    var mStatus: Int? = null
    @TableField("m_logintime")
    var mLogintime: Int? = null
    @TableField("m_loginip")
    var mLoginip: Int? = null
    @TableField("m_loginnum")
    var mLoginnum: Int? = null


    override fun pkVal(): Serializable? {
        return mId
    }

    override fun toString(): String {
        return "MacManager{" +
        ", mId=" + mId +
        ", mName=" + mName +
        ", mPassword=" + mPassword +
        ", mLevels=" + mLevels +
        ", mRandom=" + mRandom +
        ", mStatus=" + mStatus +
        ", mLogintime=" + mLogintime +
        ", mLoginip=" + mLoginip +
        ", mLoginnum=" + mLoginnum +
        "}"
    }
}
