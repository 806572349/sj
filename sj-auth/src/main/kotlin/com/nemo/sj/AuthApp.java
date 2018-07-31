package com.nemo.sj;

import com.nemo.sj.common.JsonData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * create by Nemo
 * 2018/7/25  13:00
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class,args);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public JsonData YunbaoOptException(Exception ex){
        return JsonData.Companion.fail("",ex.getMessage());
    }
}
