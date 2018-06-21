package com.cfl.xuexispace.controller.exceptionhandler;

import com.cfl.xuexispace.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 18:37
 * @Version: 1.0
 * @Description: 统一异常处理
 */
@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result errorHandler(Exception ex, HandlerMethod handlerMethod){
        Result result = new Result();
        result.setCode(500);
        result.setMsg(ex.getMessage()+":"+handlerMethod.getBean().getClass()+"."+handlerMethod.getMethod().getName());
        return result;
    }
}
