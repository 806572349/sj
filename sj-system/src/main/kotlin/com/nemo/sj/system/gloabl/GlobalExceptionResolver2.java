package com.nemo.sj.system.gloabl;

import com.nemo.sj.common.JsonData;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * create by Nemo
 * 2018/8/17  18:21
 */
@ControllerAdvice
public class GlobalExceptionResolver2 {


    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public JsonData bindExceptionHandler(BindException ex){
        return JsonData.Companion.fail(null,ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
