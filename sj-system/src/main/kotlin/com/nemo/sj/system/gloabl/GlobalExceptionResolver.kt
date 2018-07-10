package com.nemo.sj.system.gloabl

import com.nemo.sj.base.BaseExceptionResolver
import com.nemo.sj.common.JsonData
import com.nemo.sj.exception.PermissionException
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView

/**
 *  create by Nemo
 *  2018/7/10  22:39
 */

@ControllerAdvice
class GlobalExceptionResolver : BaseExceptionResolver() {


    @ExceptionHandler(value = [(PermissionException::class)])
    fun exceptionHandler(ex:PermissionException): ModelAndView {
        val jsonData = JsonData.fail(ex.message!!)
        log.error("出现错误：{}",ex.message)
        return ModelAndView("exception",jsonData.toMap())
    }

    @ExceptionHandler(value = [(Exception::class)])
    fun exceptionHandler(ex:Exception): JsonData {
        val jsonData = JsonData.fail(ex.message!!)
        log.error("出现错误：{}",ex.message)
        return jsonData;
    }
}