package com.cfl.xuexispace.mapper;

import com.cfl.xuexispace.entity.Log;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 21:59
 * @Version: 1.0
 * @Description: 日志Mapper
 */
public interface LogMapper {

    /**
     * 添加日志
     * @param log
     * @return
     */
    int insertLog(Log log);

    /**
     * 查询日志
     * @param log
     * @return
     */
    List<Log> selectLog(Log log);

    /**
     * 查询日志数量
     * @param log
     * @return
     */
    List<Log> selectLogCount(Log log);

    /**
     * 删除日志
     * @return
     */
    public int deleteLogById(String[] ids);
}
