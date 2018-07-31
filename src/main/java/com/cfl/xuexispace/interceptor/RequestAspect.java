package com.cfl.xuexispace.interceptor;

import com.cfl.xuexispace.utils.CommonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/27 21:34
 * @Version: 1.0
 * @Description: aop
 */
@Aspect
@Component
public class RequestAspect {

    @Pointcut("execution(public * com.cfl.xuexispace.controller.bg.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        List<String> list = new ArrayList<String>();
        list.add("/bgmanage/tologin");
        list.add("/bgmanage/login");
        String url = request.getServletPath();
        boolean bool = list.contains(url);
        if(!bool){
            Object user = request.getSession(true).getAttribute("user");
            if((CommonUtils.isEmpty(user))){
                response.sendRedirect(request.getContextPath()+"/bgmanage/tologin");
            }
        }
    }
}
