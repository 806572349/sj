package com.nemo.sj.system

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 *  create by Nemo
 *  2018/7/9  22:55
 */

@EnableDiscoveryClient
@SpringBootApplication
class SystemApp {
}
fun main(args: Array<String>) {
    SpringApplication.run(SystemApp::class.java, *args)

}