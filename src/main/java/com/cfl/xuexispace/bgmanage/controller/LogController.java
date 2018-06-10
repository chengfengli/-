package com.cfl.xuexispace.bgmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/10 14:02
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("bgmanage/log")
public class LogController {

    @RequestMapping("list")
    public String toLogList(){
        return "bgmanage/log";
    }
}
