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
@TableName("mac_art_type")
class MacArtType : Model<MacArtType>() {

    @TableId(value = "t_id", type = IdType.AUTO)
    var tId: Int? = null
    @TableField("t_name")
    var tName: String? = null
    @TableField("t_enname")
    var tEnname: String? = null
    @TableField("t_pid")
    var tPid: Int? = null
    @TableField("t_sort")
    var tSort: Int? = null
    @TableField("t_hide")
    var tHide: Int? = null
    @TableField("t_tpl")
    var tTpl: String? = null
    @TableField("t_tpl_list")
    var tTplList: String? = null
    @TableField("t_tpl_art")
    var tTplArt: String? = null
    @TableField("t_key")
    var tKey: String? = null
    @TableField("t_des")
    var tDes: String? = null
    @TableField("t_title")
    var tTitle: String? = null
    @TableField("t_union")
    var tUnion: String? = null


    override fun pkVal(): Serializable? {
        return tId
    }

    override fun toString(): String {
        return "MacArtType{" +
        ", tId=" + tId +
        ", tName=" + tName +
        ", tEnname=" + tEnname +
        ", tPid=" + tPid +
        ", tSort=" + tSort +
        ", tHide=" + tHide +
        ", tTpl=" + tTpl +
        ", tTplList=" + tTplList +
        ", tTplArt=" + tTplArt +
        ", tKey=" + tKey +
        ", tDes=" + tDes +
        ", tTitle=" + tTitle +
        ", tUnion=" + tUnion +
        "}"
    }
}
