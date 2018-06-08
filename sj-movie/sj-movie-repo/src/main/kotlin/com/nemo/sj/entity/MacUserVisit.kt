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
@TableName("mac_user_visit")
class MacUserVisit : Model<MacUserVisit>() {

    @TableId(value = "uv_id", type = IdType.AUTO)
    var uvId: Int? = null
    @TableField("uv_uid")
    var uvUid: Int? = null
    @TableField("uv_ip")
    var uvIp: Int? = null
    @TableField("uv_ly")
    var uvLy: String? = null
    @TableField("uv_time")
    var uvTime: Int? = null


    override fun pkVal(): Serializable? {
        return uvId
    }

    override fun toString(): String {
        return "MacUserVisit{" +
        ", uvId=" + uvId +
        ", uvUid=" + uvUid +
        ", uvIp=" + uvIp +
        ", uvLy=" + uvLy +
        ", uvTime=" + uvTime +
        "}"
    }
}
