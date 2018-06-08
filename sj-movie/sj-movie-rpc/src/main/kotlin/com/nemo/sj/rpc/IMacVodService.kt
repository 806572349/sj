package com.nemo.sj.rpc;

import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.entity.MacVod;
import com.baomidou.mybatisplus.service.IService;
import com.nemo.sj.params.MacVodParams

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nemo
 * @since 2018-06-08
 */
interface IMacVodService : IService<MacVod> {
    fun queryPage(page: Page<MacVod>, macVodParams: MacVodParams): Page<MacVod>
    fun findOne(macVod: MacVod): MacVod
}
