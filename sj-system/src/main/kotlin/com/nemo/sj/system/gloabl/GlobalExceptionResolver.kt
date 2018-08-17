package com.nemo.sj.system.gloabl

import com.nemo.sj.base.BaseExceptionResolver
import com.nemo.sj.common.JsonData
import com.nemo.sj.exception.OptException
import com.nemo.sj.exception.ParamException
import com.nemo.sj.exception.PermissionException
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
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
    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    @ExceptionHandler(value = [(ParamException::class)])
    fun exceptionHandler(ex:ParamException): JsonData {
        val jsonData = JsonData.fail(ex.message!!)
        log.error("出现错误json：{}",ex.message)
        return jsonData;
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(value = [(OptException::class)])
    fun exceptionHandler(ex:OptException): JsonData {
        val jsonData = JsonData.fail(ex.message!!)
        jsonData.msg=ex.message!!
        log.error("出现错误json：{}",ex.message)
        return jsonData;
    }
}