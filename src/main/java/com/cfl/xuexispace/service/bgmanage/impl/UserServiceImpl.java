package com.cfl.xuexispace.service.bgmanage.impl;

import com.cfl.xuexispace.entity.User;
import com.cfl.xuexispace.mapper.UserMapper;
import com.cfl.xuexispace.service.bgmanage.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 15:51
 * @Version: 1.0
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectUser(User user){
        Object obj = userMapper.selectUser(user);
        return userMapper.selectUser(user);
    }
}
