package com.cfl.xuexispace.entity;


import com.cfl.xuexispace.utils.CommonUtils;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/20 21:16
 * @Version: 1.0
 * @Description:
 */
public class Page {
    //页码值
    private Integer page;
    //每页数量
    private Integer limit;

    public Integer getPage() {
        if(CommonUtils.isNotEmpty(page)){
            return (page-1)*limit;
        }
        return null;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
