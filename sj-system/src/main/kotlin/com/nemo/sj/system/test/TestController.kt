package com.nemo.sj.system.test

import com.nemo.sj.common.BeanValidator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *  create by Nemo
 *  2018/7/10  23:22
 */

@RestController
@RequestMapping("/test")
class TestController {


    @GetMapping
    fun  test(vo:TestVo){

            BeanValidator.check(vo);
        println("asd")

    }


}