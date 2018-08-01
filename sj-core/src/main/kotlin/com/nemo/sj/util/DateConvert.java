package com.nemo.sj.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 日期转化工具
 * Created by Nemo
 * on 2018/4/20:15:48
 */
@Component
public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String stringDate) {
        if (StringUtils.isNotEmpty(stringDate)){
            Long longDate = Long.valueOf(stringDate);
            return new Date(longDate);
        }
        return null;

    }
}


