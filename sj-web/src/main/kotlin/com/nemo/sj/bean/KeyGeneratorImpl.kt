package com.nemo.sj.bean

import org.slf4j.LoggerFactory
import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.stereotype.Component
import java.lang.reflect.Method

/**
 *  分布式key生成器
 *  create by Nemo
 *  2018/6/9  11:01
 */
@Component("KeyGeneratorImpl")
class KeyGeneratorImpl: KeyGenerator {
    var log = LoggerFactory.getLogger(this.javaClass);
    override fun generate(target: Any, method: Method, vararg params: Any?): Any {
        val key = BaseCacheKey(target, method, params)
        return key.toString()
    }



}