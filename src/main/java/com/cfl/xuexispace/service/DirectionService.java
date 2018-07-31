package com.cfl.xuexispace.service;

import com.cfl.xuexispace.entity.Direction;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/22 20:05
 * @Version: 1.0
 * @Description: 笔记方向Service层接口
 */
public interface DirectionService {
    public int insert(String directionName, String createUser);

    public List<Direction> select(Direction direction);

    public int delete(String id);

    public int update(Direction direction);
}
