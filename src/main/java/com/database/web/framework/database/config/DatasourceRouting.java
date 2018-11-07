package com.database.web.framework.database.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

public class DatasourceRouting extends AbstractRoutingDataSource{
    private final int dataSourceNumber;
    private AtomicInteger count = new AtomicInteger(0);

    @Value("${spring.datasource.opencluster}")
    private boolean opencluster = true;

    public DatasourceRouting(int dataSourceNumber) {
        this.dataSourceNumber = dataSourceNumber;
    }

    @Override
    protected Object determineCurrentLookupKey() {

        String typeKey = DatasourceContextHolder.getJdbcType();

        //如果开启读写分离 则按路由返回数据源
        if(opencluster) {
            if (DatasourceType.write.getType().equals(typeKey))
                return DatasourceType.write.getType();
            int number = count.getAndAdd(1);
            int lookupKey = number % dataSourceNumber;
            return new Integer(lookupKey);
        }
        //如果未开启则永远返回写数据库
        else {
            return DatasourceType.write.getType();
        }
    }
}
