package com.cfl.xuexispace.service.bgmanage;

import com.cfl.xuexispace.entity.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 22:12
 * @Version: 1.0
 * @Description:
 */
public interface LogService {
    int insertLog(Log log,HttpServletRequest request);

    List<Log> selectLog(Log log);

    int selectLogCount(Log log);

    int deleteLog(String id);
}
