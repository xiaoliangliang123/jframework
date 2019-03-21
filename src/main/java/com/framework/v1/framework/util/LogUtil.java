package com.framework.v1.framework.util;

import com.framework.v1.framework.database.config.DatasourceContextHolder;
import com.framework.v1.framework.database.config.DatasourceType;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LogUtil {

    public static void logAopExecute(JdbcTemplate jdbcTemplate, Logger logger , String sqlLog, String ps, Long executeTime) {
        if(DatasourceType.read.getType() == DatasourceContextHolder.getJdbcType()) {
            insertIntoReadSqlMonitor(logger,jdbcTemplate,sqlLog,ps,executeTime);
        }else {
            insertIntoWriteSqlMonitor(logger,jdbcTemplate,sqlLog,ps,executeTime);
        }
    }

    private static void insertIntoReadSqlMonitor(Logger logger,JdbcTemplate jdbcTemplate,String sql, String params, Long executeTime) {
        String msql = "insert into sys_monitor_sql values(?,?,?,?,?,?,?,?,?) ";
        String id = GenerateUtil.uuid();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        RemoteVister remoteVister =  WebPropertyUtil.getRemoteVister(request);
        jdbcTemplate.update(msql,new Object[]{id,sql,params,executeTime,remoteVister.getIP(),remoteVister.getHost(),remoteVister.getUsername(),remoteVister.getUrl(),remoteVister.getTime()});
        logger.info("execute  action :read , sql :" + sql + " , SqlParams :" + params + " invokeTime " + executeTime + " ms");

    }

    private static void insertIntoWriteSqlMonitor(Logger logger,JdbcTemplate jdbcTemplate,String sql, String params, Long executeTime) {
        String msql = "insert into sys_monitor_sql values(?,?,?,?,?,?,?,?,?) ";
        String id = GenerateUtil.uuid();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RemoteVister remoteVister =  WebPropertyUtil.getRemoteVister(request);
        jdbcTemplate.update(msql,new Object[]{id,sql,params,executeTime,remoteVister.getIP(),remoteVister.getHost(),remoteVister.getUsername(),remoteVister.getUrl(),remoteVister.getTime()});
        logger.info("execute  action :write , sql :" + sql + " , SqlParams :" + params + " invokeTime " + executeTime + " ms");
    }

    public static void logModelExcute(JdbcTemplate jdbcTemplate,Logger logger ,String sql, List<String> pkValues, Long executeTime) {
        String params = getParams(pkValues);
        if(DatasourceType.read.getType() == DatasourceContextHolder.getJdbcType()) {
            //insertIntoReadSqlMonitor(logger,jdbcTemplate,sql,params,executeTime);
            logger.info("execute  action :read , sql :" + sql + " , SqlParams :" + params + " invokeTime " + executeTime + " ms");
        }else {
            //insertIntoWriteSqlMonitor(logger,jdbcTemplate,sql,params,executeTime);
            logger.info("execute  action :write , sql :" + sql + " , SqlParams :" + params + " invokeTime " + executeTime + " ms");

        }
    }

    private static String getParams(List<String> pkValues) {
        if(pkValues == null ||pkValues.isEmpty())
            return "null";
        String params = "";
        for(String value:pkValues){
            params = params +value+",";
        }
        return params;
    }
}
