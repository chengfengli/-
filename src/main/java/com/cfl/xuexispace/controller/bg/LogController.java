package com.cfl.xuexispace.controller.bg;

import com.cfl.xuexispace.entity.Log;
import com.cfl.xuexispace.entity.Result;
import com.cfl.xuexispace.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/10 14:02
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("bgmanage")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("log")
    public String toLogList(){
        return "bgmanage/log";
    }

    /**
     * 日志列表
     * @param log
     * @return
     */
    @RequestMapping("logList")
    @ResponseBody
    public Result getLogs(Log log){
        Result result = new Result();
        result.setCode(0);
        result.setData(logService.selectLog(log));
        int count = logService.selectLogCount(log);
        result.setCount(count);
        return result;
    }
    @RequestMapping("deleteLog")
    @ResponseBody
    public Result deleteLog(String logId){
        Result result = new Result();
        int count = logService.deleteLog(logId);
        if(count>0){
            result.setCode(0);
            result.setMsg("删除成功");
        }else{
            result.setCode(400);
            result.setMsg("删除失败");
        }
        return  result;
    }
}
