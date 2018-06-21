package com.cfl.xuexispace.mapper;

import com.cfl.xuexispace.entity.User;
import com.cfl.xuexispace.provider.UserMapperProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 15:28
 * @Version: 1.0
 * @Description:
 */

public interface UserMapper {
    @SelectProvider(type = UserMapperProvider.class, method = "selectUser")
    public List<User> selectUser(User user);
}
