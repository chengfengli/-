package com.cfl.xuexispace.mapper;

import com.cfl.xuexispace.entity.Direction;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/22 19:55
 * @Version: 1.0
 * @Description: 笔记方向mapper层
 */
public interface DirectionMapper {
    /**
     * 添加笔记方向
     * @param direction
     * @return
     */
    public int insert(Direction direction);

    /**
     * 查询笔记方向
     * @return
     */
    public List<Direction> select(Direction direction);

    /**
     * 删除笔记方向
     * @return
     */
    public int delete(String[] id);
    /**
     * 修改笔记方向
     * @return
     */
    public int update(Direction direction);
}
