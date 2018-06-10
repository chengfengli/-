package com.cfl.xuexispace.bgmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/10 14:04
 * @Version: 1.0
 * @Description: 笔记方向
 */
@Controller
@RequestMapping("bgmanage/direction")
public class DirectionController {

    @RequestMapping("list")
    public String toDirection(){
        return "bgmanage/direction";
    }
}
