package com.cfl.xuexispace.MyInterceptor;

import com.cfl.xuexispace.utils.CommonUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 21:59
 * @Version: 1.0
 * @Description: 拦截器
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession(true).getAttribute("user");
        if(CommonUtils.isEmpty(user)){
            response.sendRedirect(request.getContextPath()+"/bgmanage/tologin");
            return false;
        }else{
            return true;
        }
    }
}
