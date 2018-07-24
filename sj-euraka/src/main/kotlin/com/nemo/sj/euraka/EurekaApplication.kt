package com.nemo.sj.euraka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
 *  create by Nemo
 *  2018/7/21  16:48
 */
@EnableEurekaServer
@SpringBootApplication
class EurekaApplication
    fun main(args: Array<String>) {
        SpringApplication.run(EurekaApplication::class.java, *args)
    }
