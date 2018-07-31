package com.cfl.xuexispace.interceptor;

import com.cfl.xuexispace.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/28 21:31
 * @Version: 1.0
 * @Description: 异常捕获类
 */
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result resultError(Exception e, HandlerMethod handlerMethod){
        Result result = new Result();
        result.setCode(500);
        String className = handlerMethod.getBean().getClass().getName();
        String methodName = handlerMethod.getMethod().getName();
        result.setMsg("系统异常："+e.getMessage()+"<br>"+className+"."+methodName);
        return  result;
    }
}
