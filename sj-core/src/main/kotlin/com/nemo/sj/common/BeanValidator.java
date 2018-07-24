package com.nemo.sj.common;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nemo.sj.exception.ParamException;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;


/**
 *
 * 工具参数检验类
 * Created with IntelliJ IDEA.
 * User: Nemo
 * Date: 2018/3/5
 * To change this template use File | Settings | File Templates.
 */
public class BeanValidator {
    private static ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();

    public static <T> Map<String,String> validata(T t,Class... groups){
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
        if (validate.isEmpty()){
            return Collections.emptyMap();
        }else {
            LinkedHashMap errors= Maps.newLinkedHashMap();
            Iterator iterator=validate.iterator();
            while (iterator.hasNext()){
                ConstraintViolation violation=(ConstraintViolation)iterator.next();
                errors.put(violation.getPropertyPath().toString(),violation.getMessage());
            }
            return errors;
        }
    }

    public static Map<String,String> validataList(Collection<?>collection){
        Preconditions.checkNotNull(collection);
        Iterator<?> iterator = collection.iterator();
        Map errors;
        do {
            if (!iterator.hasNext())return Collections.emptyMap();
            Object obj = iterator.next();
            errors=validata(obj,new Class[0]);
        }while (errors.isEmpty());
        return errors;
    }

    public static Map<String,String> validateObject(Object first,Object... objects){
        if (objects!=null &&objects.length>0){
            return validataList(Lists.asList(first,objects));
        }else {
            return validata(first,new Class[0]);
        }

    }

    public static void check(Object param) throws ParamException {
        Map<String,String> map=BeanValidator.validateObject(param);
        if (MapUtils.isNotEmpty(map)){
            throw new ParamException(map.toString());
        }
    }


}
