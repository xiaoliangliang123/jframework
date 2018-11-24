package com.framework.v1.framework.database.config;

import com.framework.v1.framework.database.base.BaseModel;
import com.framework.v1.framework.util.LogUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatasourceAop {

    private static Logger logger = Logger.getLogger(DatasourceAop.class);



    @Around("execution(* com..framework.database.base.*.select*(..)) || execution(* com..framework.database.base.*.get*(..))|| execution(* com..framework.database.base.*.query*(..))")
    public Object doReadAdvice(ProceedingJoinPoint proceedingJoinPoint){
        try {
            DatasourceContextHolder.read();
            Object[] params =proceedingJoinPoint.getArgs();

            Long startTime = System.currentTimeMillis();
            Object obj = proceedingJoinPoint.proceed();
            Long endTime = System.currentTimeMillis();
            Long executeTime = endTime - startTime;
            return  doAop(obj,params,executeTime);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }



    @Around("execution(* com..framework.database.base.*.insert*(..)) || execution(* com..framework.database.base.*.update*(..))||execution(* com..framework.database.base.*.delete*(..))")
    public Object doWriteAdvice(ProceedingJoinPoint proceedingJoinPoint){
        try {
            DatasourceContextHolder.write();
            Object[] params =proceedingJoinPoint.getArgs();

            Long startTime = System.currentTimeMillis();
            Object obj = proceedingJoinPoint.proceed();
            Long endTime = System.currentTimeMillis();
            Long executeTime = endTime - startTime;
            return  doAop(obj,params,executeTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    private Object doAop(Object obj, Object[] params,Long executeTime) {
        if(params !=null &&params.length >0 ){
            Object sql = params[0];

            if(sql instanceof BaseModel){
                return  obj;
            }
            if(sql instanceof String && sql != null){
                String sqlLog = (String) sql;

                if(params[1] !=null ){
                    Object[] sqlParams = (Object[] )params[1];

                    StringBuilder ps =  new StringBuilder("");
                    for(Object p : sqlParams){
                        String pp = (String) p;
                        ps.append(pp+",");
                    }
                    LogUtil.logAopExecute(logger,sqlLog,ps.toString(),executeTime);
                }else {
                        LogUtil.logAopExecute(logger,sqlLog,"null",executeTime);
                }
            }
        }
        return obj;
    }
}
