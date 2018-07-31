package com.cfl.xuexispace.service.impl;

import com.cfl.xuexispace.entity.Direction;
import com.cfl.xuexispace.mapper.DirectionMapper;
import com.cfl.xuexispace.service.DirectionService;
import com.cfl.xuexispace.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/22 20:06
 * @Version: 1.0
 * @Description:
 */
@Service
public class DirectionServiceImpl implements DirectionService {
    @Autowired
    private DirectionMapper directionMapper;

    /**
     * 增加笔记方向
     * @param directionName 笔记名称
     * @param createUser 创建人
     * @return
     */
    @Override
    @Transactional
    public int insert(String directionName,String createUser) {
        Direction direction = new Direction();
        direction.setDirectionName(directionName);
        direction.setCreateUser(createUser);
        direction.setCreateTime(DateUtils.nowNetworkDate1());
        return directionMapper.insert(direction);
    }

    /**
     * 查询笔记方向
     * @return
     */
    @Override
    public List<Direction> select(Direction direction) {
        return directionMapper.select(direction);
    }

    /**
     * 删除方向
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int delete(String id) {
        return directionMapper.delete(id.split(","));
    }

    /**
     * 修改方向
     * @param direction
     * @return
     */
    @Override
    @Transactional
    public int update(Direction direction) {
        direction.setUpdateTime(DateUtils.nowNetworkDate1());
        return directionMapper.update(direction);
    }
}
