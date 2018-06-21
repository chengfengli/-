package com.cfl.xuexispace.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 21:54
 * @Version: 1.0
 * @Description: 日志实体类
 */
@Setter
@Getter
public class Log extends Page {
    private int id;
    //操作人
    private String editUser;
    //操作时间
    private String editTime;
    //描述
    private String describe;
    //ip地址
    private String ipAddress;
    //客户端类型
    private String clientType;
    //所属城市
    private String city;
    // 开始时间
    private String startTime;
    // 结束时间
    private String endTime;

    public Log() { }

    public Log(String editUser, String describe, String clientType, String city) {
        this.editUser = editUser;
        this.describe = describe;
        this.clientType = clientType;
        this.city = city;
    }
}
