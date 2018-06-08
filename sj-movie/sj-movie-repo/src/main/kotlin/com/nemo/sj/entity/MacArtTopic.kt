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
@TableName("mac_art_topic")
class MacArtTopic : Model<MacArtTopic>() {

    @TableId(value = "t_id", type = IdType.AUTO)
    var tId: Int? = null
    @TableField("t_name")
    var tName: String? = null
    @TableField("t_enname")
    var tEnname: String? = null
    @TableField("t_sort")
    var tSort: Int? = null
    @TableField("t_tpl")
    var tTpl: String? = null
    @TableField("t_pic")
    var tPic: String? = null
    @TableField("t_content")
    var tContent: String? = null
    @TableField("t_key")
    var tKey: String? = null
    @TableField("t_des")
    var tDes: String? = null
    @TableField("t_title")
    var tTitle: String? = null
    @TableField("t_hide")
    var tHide: Int? = null
    @TableField("t_level")
    var tLevel: Int? = null
    @TableField("t_up")
    var tUp: Int? = null
    @TableField("t_down")
    var tDown: Int? = null
    @TableField("t_score")
    var tScore: BigDecimal? = null
    @TableField("t_scoreall")
    var tScoreall: Int? = null
    @TableField("t_scorenum")
    var tScorenum: Int? = null
    @TableField("t_hits")
    var tHits: Int? = null
    @TableField("t_dayhits")
    var tDayhits: Int? = null
    @TableField("t_weekhits")
    var tWeekhits: Int? = null
    @TableField("t_monthhits")
    var tMonthhits: Int? = null
    @TableField("t_addtime")
    var tAddtime: Int? = null
    @TableField("t_time")
    var tTime: Int? = null
    @TableField("t_hitstime")
    var tHitstime: Int? = null


    override fun pkVal(): Serializable? {
        return tId
    }

    override fun toString(): String {
        return "MacArtTopic{" +
        ", tId=" + tId +
        ", tName=" + tName +
        ", tEnname=" + tEnname +
        ", tSort=" + tSort +
        ", tTpl=" + tTpl +
        ", tPic=" + tPic +
        ", tContent=" + tContent +
        ", tKey=" + tKey +
        ", tDes=" + tDes +
        ", tTitle=" + tTitle +
        ", tHide=" + tHide +
        ", tLevel=" + tLevel +
        ", tUp=" + tUp +
        ", tDown=" + tDown +
        ", tScore=" + tScore +
        ", tScoreall=" + tScoreall +
        ", tScorenum=" + tScorenum +
        ", tHits=" + tHits +
        ", tDayhits=" + tDayhits +
        ", tWeekhits=" + tWeekhits +
        ", tMonthhits=" + tMonthhits +
        ", tAddtime=" + tAddtime +
        ", tTime=" + tTime +
        ", tHitstime=" + tHitstime +
        "}"
    }
}
