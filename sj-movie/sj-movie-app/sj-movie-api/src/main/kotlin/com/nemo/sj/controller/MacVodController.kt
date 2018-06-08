package com.nemo.sj.controller;


import com.alibaba.dubbo.config.annotation.Reference
import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.entity.MacVod
import com.nemo.sj.params.MacVodParams
import com.nemo.sj.rpc.IMacVodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nemo
 * @since 2018-06-08
 */
@RestController
@RequestMapping("/sj/macVod")
class MacVodController{


    @Reference(check = false)
    lateinit var iMacVodService: IMacVodService;


    @Autowired
    lateinit var iMacVodServiceLocal: IMacVodService;
    /**
     * rpc调用查询
     */
    @GetMapping("/fbprpc")
    fun  queryPage(page: Page<MacVod>, macVodParams: MacVodParams):Page<MacVod>{
        val data = iMacVodService.queryPage(page, macVodParams)
        return data;
    }

    /**
     * local查询
     */
    @GetMapping("/fbp")
    fun  local(page: Page<MacVod>, macVodParams: MacVodParams):Page<MacVod>{
        val data = iMacVodServiceLocal.queryPage(page, macVodParams)
        return data;
    }

    @GetMapping("/fo")
    fun  findOne( data: MacVod):MacVod{
        val data = iMacVodService.findOne(data);
        return data;
    }
}
