package com.nemo.sj.cache;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * 缓存管理器
 */
public class CacheManager {

    public String keyPrefix = "";

    /**
     * 使用redis
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    Gson gson = new Gson();

    /**
     * 保存字符串类型结果
     * @return
     */
    public void saveObjResult(String keyStr,Object valueStr,Integer min){
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        //时间大于0，则保存含有过期时间的方法
        if(min > 0){
            opsForValue.set(keyStr, valueStr ,min, TimeUnit.MINUTES);
        }else {
            opsForValue.set(keyStr,valueStr);
        }
        return ;
    }

    /**
     * 根据键取值
     * @param keyStr
     * @return
     */
    public  Object getObjResult(String keyStr){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(keyStr);
        return o;
    }

    /**
     * 保存结果对象
     * @param key
     * @param value
     * @param type
     * @param min
     * @param <T>
     * @return
     */
    public <T>T saveResult(String key,T value ,Type type,int min){
        //添加默认保存前缀
        key = new StringBuilder(keyPrefix).append(key).toString();
        //获取旧对象
        T t = getValue(key,type);
        //保存对象
        saveValue(key,value,type,min);
        return t;
    }

    /**
     * 获取结果
     * @param key
     * @param type
     * @param <T>
     * @return
     */
    public <T>T getResult(String key, Type type){
        //添加默认保存前缀
        key = new StringBuilder(keyPrefix).append(key).toString();
        return getValue(key,type);
    }

    /**
     * 保存结果对象
     * @param key
     * @param value
     * @param type
     * @param <T>
     * @return
     */
    public <T>T saveResult(String key,T value ,Type type){
        return saveResult(key, value, type, -1);
    }

    /**
     * 根据键删除对象
     * @param key
     * @param value
     * @param type
     * @param <T>
     * @return
     */
    public <T>T deleteResult(String key,T value ,Type type){
        //添加默认保存前缀
        key = new StringBuilder(keyPrefix).append(key).toString();
        T t = getValue(key,type);
        stringRedisTemplate.delete(key);
        return t;
    }

    /**
     * 无返回值删除
     * @param key
     */
    public void deleteResult(String key){
        //添加默认保存前缀
        key = new StringBuilder(keyPrefix).append(key).toString();
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据键取值
     * @param keyStr
     * @param type
     * @param <T>
     * @return
     */
    <T>T getValue(String keyStr, Type type){
        T t = null;
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String oldStr  = opsForValue.get(keyStr);
        if(oldStr != null) {
            t = gson.fromJson(oldStr,type);
        }
        return t;
    }

    void saveValue(String keyStr, String valueStr, int min){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        //时间大于0，则保存含有过期时间的方法
        if(min > 0){
            opsForValue.set(keyStr, valueStr ,min, TimeUnit.MINUTES);
        }else {
            opsForValue.set(keyStr,valueStr);
        }
    }

    /**
     * 根据键保存值
     * @param keyStr
     * @param value
     * @param type
     * @param min
     * @param <T>
     */
    <T>void saveValue(String keyStr, T value ,Type type,int min){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String valueStr = gson.toJson(value,type);
        //时间大于0，则保存含有过期时间的方法
        if(min > 0){
            opsForValue.set(keyStr, valueStr ,min, TimeUnit.MINUTES);
        }else {
            opsForValue.set(keyStr,valueStr);
        }
    }

}
