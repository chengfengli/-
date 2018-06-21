package com.cfl.xuexispace.controller.aspect;

import com.cfl.xuexispace.entity.Log;
import com.cfl.xuexispace.service.bgmanage.LogService;
import com.cfl.xuexispace.utils.CommonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 19:22
 * @Version: 1.0
 * @Description: 定义切面，日志记录
 */
@Aspect
@Component
public class WebLogAspect {

    @Pointcut("execution(* com.cfl.xuexispace.controller..*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Exception{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURI();
        Object user = request.getSession(true).getAttribute("user");
        if(!"/bgmanage/tologin".equals(url) && !"/bgmanage/login".equals(url)){
            if((CommonUtils.isEmpty(user))){
                response.sendRedirect(request.getContextPath()+"/bgmanage/tologin");
            }
        }
    }
}
