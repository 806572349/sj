package com.nemo.sj.controller;


import com.alibaba.dubbo.config.annotation.Reference
import com.baomidou.mybatisplus.plugins.Page
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.reflect.TypeToken
import com.nemo.sj.aoppoint.CacheControllerAnnotation
import com.nemo.sj.cache.CacheManager
import com.nemo.sj.entity.MacVod
import com.nemo.sj.params.MacVodParams
import com.nemo.sj.rpc.IMacVodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.*

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

    @Autowired
    lateinit var redisTemplate: CacheManager;


    /**
     * rpc调用查询
     */
    @CacheControllerAnnotation(time = "30")
    @GetMapping("/fbprpc")
    fun  queryPage(page: Page<MacVod>, macVodParams: MacVodParams):Page<MacVod>{
        val data = iMacVodService.queryPage(page, macVodParams)
        return data;
    }

    /**
     * local查询
     */
    //这是spring 自带的cache
//    @Cacheable(keyGenerator="KeyGeneratorImpl",cacheNames = ["fbp"] )
    @GetMapping("/fbp")
    fun  local(page: Page<MacVod>, macVodParams: MacVodParams):Page<MacVod>{
        val data = iMacVodServiceLocal.queryPage(page, macVodParams)
        return data;
    }
    @Cacheable(keyGenerator="KeyGeneratorImpl",cacheNames = ["movieone"] )
    @GetMapping("/fo")
    fun  findOne( data: MacVod):MacVod{
        val data = iMacVodService.findOne(data);
        return data;
    }
}
