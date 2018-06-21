package com.cfl.xuexispace.provider;

import com.cfl.xuexispace.entity.User;
import com.cfl.xuexispace.utils.CommonUtils;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 16:37
 * @Version: 1.0
 * @Description:
 */
public class UserMapperProvider {
    public String selectUser(User user){
        String sql = "select * from users where 1=1";
        if(CommonUtils.isNotEmpty(user)){
            if(CommonUtils.isNotEmpty(user.getEmail())){
                sql += " and email = '"+user.getEmail()+"'";
            }
            if(CommonUtils.isNotEmpty(user.getAccount())){
                sql += " and account = '"+user.getAccount()+"'";
            }
            if(CommonUtils.isNotEmpty(user.getUserName())){
                sql += " and userName = '"+user.getUserName()+"'";
            }
            if(CommonUtils.isNotEmpty(user.getPassword())){
                sql += " and password = '"+user.getPassword()+"'";
            }
        }
        return sql;
    }
    
}
