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
@TableName("mac_art")
class MacArt : Model<MacArt>() {

    @TableId(value = "a_id", type = IdType.AUTO)
    var aId: Int? = null
    @TableField("a_name")
    var aName: String? = null
    @TableField("a_subname")
    var aSubname: String? = null
    @TableField("a_enname")
    var aEnname: String? = null
    @TableField("a_letter")
    var aLetter: String? = null
    @TableField("a_color")
    var aColor: String? = null
    @TableField("a_from")
    var aFrom: String? = null
    @TableField("a_author")
    var aAuthor: String? = null
    @TableField("a_tag")
    var aTag: String? = null
    @TableField("a_pic")
    var aPic: String? = null
    @TableField("a_type")
    var aType: Int? = null
    @TableField("a_topic")
    var aTopic: String? = null
    @TableField("a_level")
    var aLevel: Int? = null
    @TableField("a_hide")
    var aHide: Int? = null
    @TableField("a_lock")
    var aLock: Int? = null
    @TableField("a_up")
    var aUp: Int? = null
    @TableField("a_down")
    var aDown: Int? = null
    @TableField("a_hits")
    var aHits: Int? = null
    @TableField("a_dayhits")
    var aDayhits: Int? = null
    @TableField("a_weekhits")
    var aWeekhits: Int? = null
    @TableField("a_monthhits")
    var aMonthhits: Int? = null
    @TableField("a_addtime")
    var aAddtime: Int? = null
    @TableField("a_time")
    var aTime: Int? = null
    @TableField("a_hitstime")
    var aHitstime: Int? = null
    @TableField("a_maketime")
    var aMaketime: Int? = null
    @TableField("a_remarks")
    var aRemarks: String? = null
    @TableField("a_content")
    var aContent: String? = null


    override fun pkVal(): Serializable? {
        return aId
    }

    override fun toString(): String {
        return "MacArt{" +
        ", aId=" + aId +
        ", aName=" + aName +
        ", aSubname=" + aSubname +
        ", aEnname=" + aEnname +
        ", aLetter=" + aLetter +
        ", aColor=" + aColor +
        ", aFrom=" + aFrom +
        ", aAuthor=" + aAuthor +
        ", aTag=" + aTag +
        ", aPic=" + aPic +
        ", aType=" + aType +
        ", aTopic=" + aTopic +
        ", aLevel=" + aLevel +
        ", aHide=" + aHide +
        ", aLock=" + aLock +
        ", aUp=" + aUp +
        ", aDown=" + aDown +
        ", aHits=" + aHits +
        ", aDayhits=" + aDayhits +
        ", aWeekhits=" + aWeekhits +
        ", aMonthhits=" + aMonthhits +
        ", aAddtime=" + aAddtime +
        ", aTime=" + aTime +
        ", aHitstime=" + aHitstime +
        ", aMaketime=" + aMaketime +
        ", aRemarks=" + aRemarks +
        ", aContent=" + aContent +
        "}"
    }
}
