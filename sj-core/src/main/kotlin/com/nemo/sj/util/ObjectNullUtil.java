package com.nemo.sj.util;


import com.nemo.sj.exception.OptException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * 为空抛出异常
 */
public class ObjectNullUtil {

    public static  void isNull(Object object,String msg){
        if (object==null){
            OptException yunbaoBaseException = new OptException(msg);
            throw   yunbaoBaseException;
        }

    }


    /**
     * 相同时抛出异常信息
     * @param source
     * @param target
     * @param msg
     */
    public static  void isEqual(Integer source,Integer target,String msg){
        if (source.equals(target)){
            OptException yunbaoBaseException = new OptException(msg);

            throw   yunbaoBaseException;
        }

    }

    /**
     * 不相同时，抛出异常信息
     * @param source
     * @param target
     * @param msg
     */
    public static  void isNotEqual(Integer source,Integer target,String msg){
        if (!source.equals(target)){
            OptException yunbaoBaseException = new OptException(msg);
            throw   yunbaoBaseException;
        }

    }
    /**
     * 获取非空字段
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
