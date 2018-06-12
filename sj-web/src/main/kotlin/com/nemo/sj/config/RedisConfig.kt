package com.nemo.sj.config

import com.nemo.sj.bean.KeyGeneratorImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.cache.CacheManager
import org.springframework.data.redis.core.RedisTemplate



/**
 *  create by Nemo
 *  2018/6/9  10:20
 */
@Configuration
class RedisConfig {

    /**
     * 缓存管理器.
     * @param redisTemplate
     * @return
     */
//    @Bean
//    fun cacheManager(redisTemplate: RedisTemplate<*, *>): CacheManager {
//        return RedisCacheManager(redisTemplate)
//    }
    @Bean
    fun redisManage(): com.nemo.sj.cache.CacheManager{
        return com.nemo.sj.cache.CacheManager();
    }
}