package com.cfl.xuexispace.provider;

import com.cfl.xuexispace.entity.Log;
import com.cfl.xuexispace.utils.CommonUtils;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 22:01
 * @Version: 1.0
 * @Description: 日志操作sql语句
 */
public class LogMapperProvider {
    /**
     * 添加日志sql
     * @param log
     * @return
     */
    public String insert(Log log){
        String sql = "INSERT INTO `logs` VALUES(null,'"+log.getEditUser()+"','"+log.getEditTime()+"','"+log.getDescribe()+"','"+log.getIpAddress()+"','"+log.getClientType()+"','"+log.getCity()+"')";
        return sql;
    }

    /**
     * 查询日志sql
     * @param log
     * @return
     */
    public String selectLog(Log log){
        String sql = "SELECT * FROM `logs` WHERE 1 = 1";
        sql = getString(log, sql);
        return sql;
    }

    /**
     * 删除日志sql语句
     * @param id
     * @return
     */
    public String deleteLog(String id){
        String sql = "DELETE FROM `logs` WHERE id in ("+id+")";
        return sql;
    }

    /**
     * 查询日志数量
     * @param log
     * @return
     */
    public String selectLogCount(Log log){
        String sql = "SELECT COUNT(id) FROM `logs` WHERE 1 = 1";
        if(CommonUtils.isNotEmpty(log)){
            if(CommonUtils.isNotEmpty(log.getEditUser())){
                sql += " AND editUser = '"+log.getEditUser()+"'";
            }
            if(CommonUtils.isNotEmpty(log.getStartTime())){
                sql += " AND editTime >= '"+log.getStartTime()+" 00:00:00'";
            }
            if(CommonUtils.isNotEmpty(log.getEndTime())){
                sql += " AND editTime <= '"+log.getEndTime()+" 23:59:59'";
            }
        }
        return sql;
    }

    private String getString(Log log, String sql) {
        if(CommonUtils.isNotEmpty(log)){
            if(CommonUtils.isNotEmpty(log.getEditUser())){
                sql += " AND editUser = '"+log.getEditUser()+"'";
            }
            if(CommonUtils.isNotEmpty(log.getStartTime())){
                sql += " AND editTime >= '"+log.getStartTime()+" 00:00:00'";
            }
            if(CommonUtils.isNotEmpty(log.getEndTime())){
                sql += " AND editTime <= '"+log.getEndTime()+" 23:59:59'";
            }
            sql += " ORDER BY editTime DESC";
            if(CommonUtils.isNotEmpty(log.getPage()) && CommonUtils.isNotEmpty(log.getLimit())){
                sql += " LIMIT "+log.getPage()+", "+log.getLimit();
            }
        }
        return sql;
    }
}
