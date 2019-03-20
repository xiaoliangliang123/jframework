package com.framework.v1.framework.database.config;

import com.framework.v1.framework.database.base.BaseDao;
import com.framework.v1.framework.database.base.BaseModel;
import com.framework.v1.framework.util.LogUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatasourceAop extends BaseDao {

    private static Logger logger = Logger.getLogger(DatasourceAop.class);

    @Autowired
    private JdbcTemplate jdbcTemplate ;



    @Around("execution(* com..framework.database.base.JBaseDao.query*(..))||execution(* com..framework.database.base.JBaseDao.insert*(..))||execution(* com..framework.database.base.JBaseDao.update*(..))||execution(* com..framework.database.base.JBaseDao.delete*(..))")
    public Object doReadAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

            if (!DatasourceContextHolder.isSeturrentDb()) {
                DatasourceContextHolder.read();
            }
            Object[] params = proceedingJoinPoint.getArgs();

            Long startTime = System.currentTimeMillis();
            Object obj = proceedingJoinPoint.proceed();
            Long endTime = System.currentTimeMillis();
            Long executeTime = endTime - startTime;
            return doAop(obj, params, executeTime);


    }




    @Around("execution(* com..framework.database.base.*.insert*(..)) || execution(* com..framework.database.base.*.update*(..))||execution(* com..framework.database.base.*.delete*(..))")
    public Object doWriteAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if (!DatasourceContextHolder.isSeturrentDb()) {
            DatasourceContextHolder.write();
        }
        Object[] params = proceedingJoinPoint.getArgs();

        Long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        Long executeTime = endTime - startTime;
        return doAop(obj, params, executeTime);

    }

    private Object doAop(Object obj, Object[] params, Long executeTime) {
        if (params != null && params.length > 0) {
            Object sql = params[0];

            if (sql instanceof BaseModel) {
                return obj;
            }
            if (sql instanceof String && sql != null) {
                String sqlLog = (String) sql;

                if (params.length >1 &&params[1] != null) {
                    Object[] sqlParams = (Object[]) params[1];

                    StringBuilder ps = new StringBuilder("");
                    for (Object p : sqlParams) {
                        String pp = (String) p;
                        ps.append(pp + ",");
                    }

                    LogUtil.logAopExecute(jdbcTemplate,logger, sqlLog, ps.toString(), executeTime);
                } else {
                    LogUtil.logAopExecute(jdbcTemplate,logger, sqlLog, "null", executeTime);
                }
            }
        }
        return obj;
    }
}
