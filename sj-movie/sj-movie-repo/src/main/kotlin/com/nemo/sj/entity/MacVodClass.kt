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
@TableName("mac_vod_class")
class MacVodClass : Model<MacVodClass>() {

    @TableId(value = "c_id", type = IdType.AUTO)
    var cId: Int? = null
    @TableField("c_name")
    var cName: String? = null
    @TableField("c_pid")
    var cPid: Int? = null
    @TableField("c_sort")
    var cSort: Int? = null
    @TableField("c_hide")
    var cHide: Int? = null


    override fun pkVal(): Serializable? {
        return cId
    }

    override fun toString(): String {
        return "MacVodClass{" +
        ", cId=" + cId +
        ", cName=" + cName +
        ", cPid=" + cPid +
        ", cSort=" + cSort +
        ", cHide=" + cHide +
        "}"
    }
}
