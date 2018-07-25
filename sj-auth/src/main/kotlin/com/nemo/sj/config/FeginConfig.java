package com.nemo.sj.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * create by Nemo
 * 2018/7/25  18:46
 */
@Configuration
public class FeginConfig {
    @Bean
    public Retryer feginRetryer(){
        Retryer retryer = new Retryer.Default(100, SECONDS.toMillis(10), 3);
        return retryer;
    }
    @Bean
    public Request.Options feginOption(){
        Request.Options option = new Request.Options(7000,7000);
        return option;
    }


}
