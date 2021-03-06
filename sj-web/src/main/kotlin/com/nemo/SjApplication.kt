package com.nemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class SjApplication

fun main(args: Array<String>) {
    SpringApplication.run(SjApplication::class.java, *args)

}
