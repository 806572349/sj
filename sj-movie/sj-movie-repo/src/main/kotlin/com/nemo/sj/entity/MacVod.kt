package com.nemo.sj.entity

import com.baomidou.mybatisplus.enums.IdType
import java.math.BigDecimal
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
@TableName("mac_vod")
class MacVod : Model<MacVod>(),Serializable{

    @TableId(value = "d_id", type = IdType.AUTO)
    var dId: Int? = null
    @TableField("d_name")
    var dName: String? = null
    @TableField("d_subname")
    var dSubname: String? = null
    @TableField("d_enname")
    var dEnname: String? = null
    @TableField("d_letter")
    var dLetter: String? = null
    @TableField("d_color")
    var dColor: String? = null
    @TableField("d_pic")
    var dPic: String? = null
    @TableField("d_picthumb")
    var dPicthumb: String? = null
    @TableField("d_picslide")
    var dPicslide: String? = null
    @TableField("d_starring")
    var dStarring: String? = null
    @TableField("d_directed")
    var dDirected: String? = null
    @TableField("d_tag")
    var dTag: String? = null
    @TableField("d_remarks")
    var dRemarks: String? = null
    @TableField("d_area")
    var dArea: String? = null
    @TableField("d_lang")
    var dLang: String? = null
    @TableField("d_year")
    var dYear: Int? = null
    @TableField("d_type")
    var dType: Int? = null
    @TableField("d_type_expand")
    var dTypeExpand: String? = null
    @TableField("d_class")
    var dClass: String? = null
    @TableField("d_topic")
    var dTopic: String? = null
    @TableField("d_hide")
    var dHide: Int? = null
    @TableField("d_lock")
    var dLock: Int? = null
    @TableField("d_state")
    var dState: Int? = null
    @TableField("d_level")
    var dLevel: Int? = null
    @TableField("d_usergroup")
    var dUsergroup: Int? = null
    @TableField("d_stint")
    var dStint: Int? = null
    @TableField("d_stintdown")
    var dStintdown: Int? = null
    @TableField("d_hits")
    var dHits: Int? = null
    @TableField("d_dayhits")
    var dDayhits: Int? = null
    @TableField("d_weekhits")
    var dWeekhits: Int? = null
    @TableField("d_monthhits")
    var dMonthhits: Int? = null
    @TableField("d_duration")
    var dDuration: Int? = null
    @TableField("d_up")
    var dUp: Int? = null
    @TableField("d_down")
    var dDown: Int? = null
    @TableField("d_score")
    var dScore: BigDecimal? = null
    @TableField("d_scoreall")
    var dScoreall: Int? = null
    @TableField("d_scorenum")
    var dScorenum: Int? = null
    @TableField("d_addtime")
    var dAddtime: Int? = null
    @TableField("d_time")
    var dTime: Int? = null
    @TableField("d_hitstime")
    var dHitstime: Int? = null
    @TableField("d_maketime")
    var dMaketime: Int? = null
    @TableField("d_content")
    var dContent: String? = null
    @TableField("d_playfrom")
    var dPlayfrom: String? = null
    @TableField("d_playserver")
    var dPlayserver: String? = null
    @TableField("d_playnote")
    var dPlaynote: String? = null
    @TableField("d_playurl")
    var dPlayurl: String? = null
    @TableField("d_downfrom")
    var dDownfrom: String? = null
    @TableField("d_downserver")
    var dDownserver: String? = null
    @TableField("d_downnote")
    var dDownnote: String? = null
    @TableField("d_downurl")
    var dDownurl: String? = null


    override fun pkVal(): Serializable? {
        return dId
    }

    override fun toString(): String {
        return "MacVod{" +
        ", dId=" + dId +
        ", dName=" + dName +
        ", dSubname=" + dSubname +
        ", dEnname=" + dEnname +
        ", dLetter=" + dLetter +
        ", dColor=" + dColor +
        ", dPic=" + dPic +
        ", dPicthumb=" + dPicthumb +
        ", dPicslide=" + dPicslide +
        ", dStarring=" + dStarring +
        ", dDirected=" + dDirected +
        ", dTag=" + dTag +
        ", dRemarks=" + dRemarks +
        ", dArea=" + dArea +
        ", dLang=" + dLang +
        ", dYear=" + dYear +
        ", dType=" + dType +
        ", dTypeExpand=" + dTypeExpand +
        ", dClass=" + dClass +
        ", dTopic=" + dTopic +
        ", dHide=" + dHide +
        ", dLock=" + dLock +
        ", dState=" + dState +
        ", dLevel=" + dLevel +
        ", dUsergroup=" + dUsergroup +
        ", dStint=" + dStint +
        ", dStintdown=" + dStintdown +
        ", dHits=" + dHits +
        ", dDayhits=" + dDayhits +
        ", dWeekhits=" + dWeekhits +
        ", dMonthhits=" + dMonthhits +
        ", dDuration=" + dDuration +
        ", dUp=" + dUp +
        ", dDown=" + dDown +
        ", dScore=" + dScore +
        ", dScoreall=" + dScoreall +
        ", dScorenum=" + dScorenum +
        ", dAddtime=" + dAddtime +
        ", dTime=" + dTime +
        ", dHitstime=" + dHitstime +
        ", dMaketime=" + dMaketime +
        ", dContent=" + dContent +
        ", dPlayfrom=" + dPlayfrom +
        ", dPlayserver=" + dPlayserver +
        ", dPlaynote=" + dPlaynote +
        ", dPlayurl=" + dPlayurl +
        ", dDownfrom=" + dDownfrom +
        ", dDownserver=" + dDownserver +
        ", dDownnote=" + dDownnote +
        ", dDownurl=" + dDownurl +
        "}"
    }
}
