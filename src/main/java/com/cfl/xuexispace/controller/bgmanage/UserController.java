package com.cfl.xuexispace.controller.bgmanage;

import com.cfl.xuexispace.entity.Log;
import com.cfl.xuexispace.entity.Result;
import com.cfl.xuexispace.entity.User;
import com.cfl.xuexispace.service.bgmanage.LogService;
import com.cfl.xuexispace.service.bgmanage.UserService;
import com.cfl.xuexispace.utils.CommonUtils;
import com.cfl.xuexispace.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/9 22:53
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("bgmanage")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("tologin")
    public String toLoging(){
        return "bgmanage/login";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("home")
    public String toIndex(){
        return "bgmanage/index";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("logout")
    public String loginOut(HttpServletRequest request){
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "bgmanage/login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Result login(String account, String password, HttpServletRequest request){
        User user =  new User();
        user.setAccount(account);
        user.setPassword(password);
        Result result =  new Result();
        List<User> list = userService.selectUser(user);
        if(list.size()>0){
            result.setCode(0);
            request.getSession().setAttribute("user",list.get(0));
            Log log = new Log();
            log.setEditUser(list.get(0).getUserName());
            log.setClientType("电脑版");
            log.setDescribe(list.get(0).getUserName()+"登录系统");
            logService.insertLog(log,request);
        }else{
            result.setCode(400);
            result.setMsg("账号或密码不正确");
        }
        return result;
    }

}
