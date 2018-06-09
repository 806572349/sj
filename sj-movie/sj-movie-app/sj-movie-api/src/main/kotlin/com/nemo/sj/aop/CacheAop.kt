package com.nemo.sj.aop

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.nemo.sj.aoppoint.CacheControllerAnnotation
import com.nemo.sj.cache.CacheManager
import org.apache.commons.lang3.StringUtils
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.aspectj.weaver.tools.JoinPointMatch
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import sun.rmi.transport.ObjectTable.getTarget
import sun.rmi.transport.ObjectTable.getTarget
import java.net.SocketException


/**
 *  create by Nemo
 *  2018/6/9  13:22
 */
@Component
@Aspect
class CacheAop {


    @Autowired
    lateinit var cacheManager: CacheManager
    @Autowired
    lateinit var keyGenerator: KeyGenerator;



    @Pointcut("@annotation(com.nemo.sj.aoppoint.CacheControllerAnnotation)")
    fun pointCutMethod() {
    }
    var log = LoggerFactory.getLogger(this.javaClass);


    /**
     * cache缓存 aop处理
     */
    @Around("@annotation(cacheControllerAnnotation)")
    @Throws(JsonProcessingException::class)
    fun before(pjp: ProceedingJoinPoint, cacheControllerAnnotation: CacheControllerAnnotation): Any {
        //获取方法名称
        val methodName = pjp.signature.name
        //获取参数
        val args = pjp.args
        //获取类型
        val classTarget = pjp.target.javaClass
        //获取参数类型
        val par = (pjp.signature as MethodSignature).getParameterTypes()
        //获取方法method
        val objMethod = classTarget.getMethod(methodName, *par)
        val ra = RequestContextHolder.getRequestAttributes()
        val sra = ra as ServletRequestAttributes
        val key = cacheControllerAnnotation.key
        val time = cacheControllerAnnotation.time
        try {
            if (StringUtils.isNotEmpty(key)) {
                //缓存中取值
                val result = cacheManager.getObjResult(key)
                if (result != null) {
                    return result
                }
            }else{
                val key = keyGenerator.generate(classTarget, objMethod, args).toString()
                log.info("读取缓存的key:"+key)
                //缓存中取值
                val result = cacheManager.getObjResult(key)
                if (result != null) {
                    return result
                }
            }
        }catch (ex: SocketException){
            log.info("redis 链接异常"+ex.message)
            return pjp.proceed()

        }catch (ex:Exception){
            log.info("redis服务异常"+ex.message)
            return pjp.proceed()
        }
        //方法体执行
        val proceed = pjp.proceed()
        if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(time)) {
            //存入缓存
            cacheManager.saveObjResult(key, proceed, time.toInt());
        }else if (StringUtils.isNotEmpty(time)){
            val key = keyGenerator.generate(classTarget, objMethod, args).toString()
            log.info("存入缓存的key:"+key)
            //存入缓存
            cacheManager.saveObjResult(key, proceed, time.toInt());
        }
        //
        return proceed
    }
}