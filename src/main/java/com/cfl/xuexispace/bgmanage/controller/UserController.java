package com.cfl.xuexispace.bgmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/9 22:53
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("bgmanage/user")
public class UserController {

    @RequestMapping("tologin")
    public String toLoging(){
        return "bgmanage/login";
    }

    @RequestMapping("home")
    public String toIndex(){
        return "bgmanage/index";
    }

    /**
     * 推出
     * @return
     */
    @RequestMapping("login_out")
    public String loginOut(){
        return "bgmanage/login";
    }

}
