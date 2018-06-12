package com.nemo.sj.repo

import java.math.BigDecimal
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.io.Serializable

/**
 * <p>
 * 
 * </p>
 *
 * @author nemo
 * @since 2018-06-08
 */
@Document(indexName = "mac_vod_index",type = "mac_vod" , shards = 8, replicas = 1)
class MacVod : Serializable{
    @Id
    var dId: Int? = null
    var dName: String? = null
    var dSubname: String? = null
    var dEnname: String? = null
    var dLetter: String? = null
    var dColor: String? = null
    var dPic: String? = null
    var dPicthumb: String? = null
    var dPicslide: String? = null
    var dStarring: String? = null
    var dDirected: String? = null
    var dTag: String? = null
    var dRemarks: String? = null
    var dArea: String? = null
    var dLang: String? = null
    var dYear: Int? = null
    var dType: Int? = null
    var dTypeExpand: String? = null
    var dClass: String? = null
    var dTopic: String? = null
    var dHide: Int? = null
    var dLock: Int? = null
    var dState: Int? = null
    var dLevel: Int? = null
    var dUsergroup: Int? = null
    var dStint: Int? = null
    var dStintdown: Int? = null
    var dHits: Int? = null
    var dDayhits: Int? = null
    var dWeekhits: Int? = null
    var dMonthhits: Int? = null
    var dDuration: Int? = null
    var dUp: Int? = null
    var dDown: Int? = null
    var dScore: BigDecimal? = null
    var dScoreall: Int? = null
    var dScorenum: Int? = null
    var dAddtime: Int? = null
    var dTime: Int? = null
    var dHitstime: Int? = null
    var dMaketime: Int? = null
    var dContent: String? = null
    var dPlayfrom: String? = null
    var dPlayserver: String? = null
    var dPlaynote: String? = null
    var dPlayurl: String? = null
    var dDownfrom: String? = null
    var dDownserver: String? = null
    var dDownnote: String? = null
    var dDownurl: String? = null




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
