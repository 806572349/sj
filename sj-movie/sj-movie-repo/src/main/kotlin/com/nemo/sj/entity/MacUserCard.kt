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
@TableName("mac_user_card")
class MacUserCard : Model<MacUserCard>() {

    @TableId(value = "c_id", type = IdType.AUTO)
    var cId: Int? = null
    @TableField("c_number")
    var cNumber: String? = null
    @TableField("c_pass")
    var cPass: String? = null
    @TableField("c_money")
    var cMoney: Int? = null
    @TableField("c_point")
    var cPoint: Int? = null
    @TableField("c_used")
    var cUsed: Int? = null
    @TableField("c_sale")
    var cSale: Int? = null
    @TableField("c_user")
    var cUser: Int? = null
    @TableField("c_addtime")
    var cAddtime: Int? = null
    @TableField("c_usetime")
    var cUsetime: Int? = null


    override fun pkVal(): Serializable? {
        return cId
    }

    override fun toString(): String {
        return "MacUserCard{" +
        ", cId=" + cId +
        ", cNumber=" + cNumber +
        ", cPass=" + cPass +
        ", cMoney=" + cMoney +
        ", cPoint=" + cPoint +
        ", cUsed=" + cUsed +
        ", cSale=" + cSale +
        ", cUser=" + cUser +
        ", cAddtime=" + cAddtime +
        ", cUsetime=" + cUsetime +
        "}"
    }
}
