package com.cfl.xuexispace.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 15:54
 * @Version: 1.0
 * @Description: 接口统一返回对象封装
 */
@Getter
@Setter
public class Result {
    private int code;
    private String msg;
    private Object data;
    private int count;
}
