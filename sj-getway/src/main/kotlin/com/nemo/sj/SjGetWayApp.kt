package com.nemo.sj

import org.springframework.boot.SpringApplication
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

/**
 *  create by Nemo
 *  2018/7/24  15:37
 */
@EnableZuulProxy
@EnableFeignClients
@SpringCloudApplication
class SjGetWayApp

    fun main(args: Array<String>) {
        SpringApplication.run(SjGetWayApp::class.java, *args)
    }

