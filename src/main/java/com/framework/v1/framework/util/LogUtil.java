package com.framework.v1.framework.util;

import com.framework.v1.framework.database.config.DatasourceContextHolder;
import com.framework.v1.framework.database.config.DatasourceType;
import org.apache.log4j.Logger;

import java.util.List;

public class LogUtil {

    public static void logAopExecute(Logger logger ,String sqlLog, String ps, Long executeTime) {
        if(DatasourceType.read.getType() == DatasourceContextHolder.getJdbcType()) {
            logger.info("execute  action :read , sql :" + sqlLog + " , SqlParams :" + ps + " invokeTime " + executeTime + " ms");
        }else {
            logger.info("execute  action :write , sql :" + sqlLog + " , SqlParams :" + ps + " invokeTime " + executeTime + " ms");
        }
    }

    public static void logModelExcute(Logger logger ,String sql, List<String> pkValues, Long executeTime) {
        String params = getParams(pkValues);
        if(DatasourceType.read.getType() == DatasourceContextHolder.getJdbcType()) {

            logger.info("execute  action :read , sql :" + sql + " , SqlParams :" + params + " invokeTime " + executeTime + " ms");
        }else {
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
