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
@TableName("mac_user_pay")
class MacUserPay : Model<MacUserPay>() {

    @TableId(value = "p_id", type = IdType.AUTO)
    var pId: Int? = null
    @TableField("p_order")
    var pOrder: Int? = null
    @TableField("p_uid")
    var pUid: Int? = null
    @TableField("p_price")
    var pPrice: Int? = null
    @TableField("p_time")
    var pTime: Int? = null
    @TableField("p_point")
    var pPoint: Int? = null
    @TableField("p_status")
    var pStatus: Int? = null


    override fun pkVal(): Serializable? {
        return pId
    }

    override fun toString(): String {
        return "MacUserPay{" +
        ", pId=" + pId +
        ", pOrder=" + pOrder +
        ", pUid=" + pUid +
        ", pPrice=" + pPrice +
        ", pTime=" + pTime +
        ", pPoint=" + pPoint +
        ", pStatus=" + pStatus +
        "}"
    }
}
