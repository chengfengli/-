package com.cfl.xuexispace.service.bgmanage;

import com.cfl.xuexispace.entity.User;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 15:50
 * @Version: 1.0
 * @Description:
 */
public interface UserService {
    public List<User> selectUser(User user);
}
