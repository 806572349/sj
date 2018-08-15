package com.nemo.sj.miaosha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
public class SjMiaoshaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjMiaoshaApplication.class, args);
    }
}
