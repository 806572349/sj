package com.nemo.sj.system.gloabl

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 *  create by Nemo
 *  2018/7/10  22:43
 */
@Controller
@RequestMapping("/test")
class ExceptionController {


    @GetMapping
    fun test():String{
        return "jsonView";
    }
}