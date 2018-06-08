package com.nemo.sj.dao

import com.baomidou.mybatisplus.mapper.Condition
import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.baomidou.mybatisplus.mapper.Wrapper
import com.baomidou.mybatisplus.plugins.Page
import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.nemo.mp.base.BaseDao
import com.nemo.sj.entity.MacVod
import com.nemo.sj.mapper.MacVodMapper
import com.nemo.sj.params.MacVodParams

import org.apache.commons.lang3.StringUtils
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import javax.annotation.Resource

/**
 *  create by Nemo
 *  2018/6/8  10:24
 */
@Repository
class MacVodDao : BaseDao() {

    @Resource
    lateinit var macVodMapper: MacVodMapper;

    fun queryPage(macVodParams: MacVodParams): Wrapper<MacVod> {

        var condition = Condition.wrapper<MacVod>()
        if (StringUtils.isNotBlank(macVodParams.dEnname)) {
            condition.like("d_enname", macVodParams.dEnname);
        }
        if (StringUtils.isNotBlank(macVodParams.dName)) {
            condition.like("d_name", macVodParams.dName);
        }
        if (macVodParams.dType != null) {
            condition.like("d_type", macVodParams.dType.toString());
        }
        if (macVodParams.dYear != null) {
            condition.like("d_year", macVodParams.dYear.toString());
        }
        return condition;
    }

    fun findOne(data: MacVod): MacVod {
        val macVod = macVodMapper.selectOne(data);
        return macVod;
    }
}