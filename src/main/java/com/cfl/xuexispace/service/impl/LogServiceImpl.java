package com.cfl.xuexispace.service.impl;

import com.cfl.xuexispace.entity.Log;
import com.cfl.xuexispace.mapper.LogMapper;
import com.cfl.xuexispace.service.LogService;
import com.cfl.xuexispace.utils.CommonUtils;
import com.cfl.xuexispace.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public int insertLog(Log log, HttpServletRequest request) {
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
        return logMapper.selectLogCount(log).size();
    }

    /**
     * 删除日志
     * @param logId
     * @return
     */
    @Override
    @Transactional
    public int deleteLog(String logId) {
        int count = logMapper.deleteLogById(logId.split(","));
        return count;
    }
}
