package com.cfl.xuexispace.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/9 22:42
 * @Version: 1.0
 * @Description: 用户类实体
 */
@Getter
@Setter
public class User {
    private int ip;
    //登陆账号
    private String account;
    //用户名
    private String userName;
    //登陆密码
    private String password;
    //绑定邮箱
    private String email;
    //用户类型
    private int type;
    //注册时间
    private String registerTime;
    //注册IP
    private String registerIP;
    //注册时间
    private String registerCity;
    //上次登陆时间
    private String loginTime;
    //上次登陆时间
    private String loginCity;
    //上次登陆IP
    private String loginIP;
}
