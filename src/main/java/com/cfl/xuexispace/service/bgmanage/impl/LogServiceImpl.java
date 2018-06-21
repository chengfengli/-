package com.cfl.xuexispace.service.bgmanage.impl;

import com.cfl.xuexispace.entity.Log;
import com.cfl.xuexispace.mapper.LogMapper;
import com.cfl.xuexispace.service.bgmanage.LogService;
import com.cfl.xuexispace.utils.CommonUtils;
import com.cfl.xuexispace.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 22:13
 * @Version: 1.0
 * @Description:
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    /**
     * 添加日志
     * @param log
     * @return
     */
    @Override
    public int insertLog(Log log,HttpServletRequest request) {
        log.setEditTime(DateUtils.nowNetworkDate1());
        log.setIpAddress(CommonUtils.getClientIP(request));
        log.setCity(CommonUtils.getIpCity(log.getIpAddress()));
        int count = logMapper.insertLog(log);
        return count;
    }

    /**
     * 查询日志
     * @param log
     * @return
     */
    @Override
    public List<Log> selectLog(Log log) {
        List<Log> list = logMapper.selectLog(log);
        return list;
    }

    /**
     * 获取日志数量
     * @param log
     * @return
     */
    @Override
    public int selectLogCount(Log log) {
        return logMapper.selectLogCount(log);
    }

    /**
     * 删除日志
     * @param id
     * @return
     */
    @Override
    public int deleteLog(String id) {
        int count = logMapper.deleteLogById(id);
        return count;
    }
}
