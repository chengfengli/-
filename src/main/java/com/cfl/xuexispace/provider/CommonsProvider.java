package com.cfl.xuexispace.provider;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/20 21:43
 * @Version: 1.0
 * @Description: 公共查询sql语句
 */
public class CommonsProvider {
    /**
     * 查询数量
     * @return
     */
    public String selectCount(String tableName){
        return "SELECT COUNT(id) FROM `"+tableName+"`";
    }
}
