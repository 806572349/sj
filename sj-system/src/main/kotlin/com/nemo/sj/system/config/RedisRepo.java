package com.nemo.sj.system.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.ServletWebRequest;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * create by Nemo
 * 2018/7/26  11:38
 */
@Repository
public class RedisRepo {


    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.imooc.security.core.validate.code.ValidateCodeRepository#save(org.
     * springframework.web.context.request.ServletWebRequest,
     * com.imooc.security.core.validate.code.ValidateCode,
     * com.imooc.security.core.validate.code.ValidateCodeType)
     */
    public void save(String key,Object value,Integer time,TimeUnit timeType) {
        redisTemplate.opsForValue().set(key, value, time,timeType);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.imooc.security.core.validate.code.ValidateCodeRepository#get(org.
     * springframework.web.context.request.ServletWebRequest,
     * com.imooc.security.core.validate.code.ValidateCodeType)
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.imooc.security.core.validate.code.ValidateCodeRepository#remove(org.
     * springframework.web.context.request.ServletWebRequest,
     * com.imooc.security.core.validate.code.ValidateCodeType)
     */
    public void remove(String key) {
        redisTemplate.delete(key);
    }
}
