package com.cfl.xuexispace.entity;


import com.cfl.xuexispace.utils.CommonUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/20 21:16
 * @Version: 1.0
 * @Description: 分页查询所需字段
 */
@Setter
@Getter
public class Page {
    //页码值
    private Integer page;
    //每页数量
    private Integer limit;
    private String createTime;
    private String createUser;
    private String updateTime="";
    private String updateUser="";
    public String getCreateTime() {
        if(CommonUtils.isNotEmpty(createTime)){
            return createTime.substring(0,16);
        }
        return "";
    }

    public String getUpdateTime() {
        if(CommonUtils.isNotEmpty(updateTime)){
            return updateTime.substring(0,16);
        }
        return "";
    }

    public Integer getPage() {
        if(CommonUtils.isNotEmpty(page)){
            return (page-1)*limit;
        }
        return null;
    }
}
