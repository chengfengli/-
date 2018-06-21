package com.cfl.xuexispace.mapper;

import com.cfl.xuexispace.entity.Log;
import com.cfl.xuexispace.provider.CommonsProvider;
import com.cfl.xuexispace.provider.LogMapperProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

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
    @InsertProvider(type=LogMapperProvider.class,method = "insert")
    int insertLog(Log log);

    /**
     * 查询日志
     * @param log
     * @return
     */
    @SelectProvider(type = LogMapperProvider.class,method = "selectLog")
    List<Log> selectLog(Log log);

    /**
     * 查询日志数量
     * @param log
     * @return
     */
    @SelectProvider(type = LogMapperProvider.class,method = "selectLogCount")
    public int selectLogCount(Log log);

    /**
     * 删除日志
     * @return
     */
    @DeleteProvider(type = LogMapperProvider.class,method = "deleteLog")
    public int deleteLogById(String id);
}
