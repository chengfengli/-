package com.cfl.xuexispace.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 14:49
 * @Version: 1.0
 * @Description: 基类
 */
@Getter
@Setter
public class BaseEntity {
    private int id;
    private String createTime;
    private String createUser;
    private String updateTime;
    private String updateUser;
}
