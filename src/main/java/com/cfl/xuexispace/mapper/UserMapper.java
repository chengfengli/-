package com.cfl.xuexispace.mapper;

import com.cfl.xuexispace.entity.User;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 15:28
 * @Version: 1.0
 * @Description:
 */

public interface UserMapper {
    public List<User> selectUser(User user);
}
