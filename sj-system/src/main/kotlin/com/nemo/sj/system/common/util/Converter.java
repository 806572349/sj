package com.nemo.sj.system.common.util;

/**
 * create by Nemo
 * 2018/7/24  14:22
 */
public interface Converter<S,T> {
    T doForward(S s);

    S doBackward(T t);


}
