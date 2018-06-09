package com.nemo.sj.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nemo.sj.aoppoint.CacheControllerAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.nemo.sj.cache.CacheManager;
/**
 * create by Nemo
 * 2018/6/9  13:34
 */
@Component
@Aspect
public class CaheAop2 {



    @Pointcut("@annotation(com.nemo.sj.aoppoint.CacheControllerAnnotation)")
    public void pointCutMethod() {
    }

//    @Around("@annotation(cacheControllerAnnotation)")
    public  Object before(ProceedingJoinPoint pjp, CacheControllerAnnotation cacheControllerAnnotation) throws Throwable {
        String key = cacheControllerAnnotation.key();
        String time = cacheControllerAnnotation.time();
        System.out.println("123:"+key);
        
        Object proceed = pjp.proceed();
        return proceed;
    }


}
