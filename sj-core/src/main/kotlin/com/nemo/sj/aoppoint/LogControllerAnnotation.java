package com.nemo.sj.aoppoint;

import java.lang.annotation.*;

/**
 *
 * controller aop
 * Created by Nemo
 * on 2018/4/21:10:02
 */
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Target(ElementType.METHOD)//目标是方法
@Documented//文档生成时，该注解将被包含在javadoc中，可去掉
public @interface LogControllerAnnotation {
}
