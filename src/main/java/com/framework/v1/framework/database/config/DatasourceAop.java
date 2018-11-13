package com.framework.v1.framework.database.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatasourceAop {
    @Before("execution(* com..framework.database.base.*.select*(..)) || execution(* com..framework.database.base.*.get*(..))|| execution(* com..framework.database.base.*.query*(..))")
    public void setReadDataSourceType() {
        DatasourceContextHolder.read();
    }

    @Before("execution(* com..framework.database.base.*.insert*(..)) || execution(* com..framework.database.base.*.update*(..))")
    public void setWriteDataSourceType() {
        DatasourceContextHolder.write();
    }


}
