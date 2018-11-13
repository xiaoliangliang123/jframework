package com.framework.v1.framework.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DatasourceProxy {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;




    @Autowired
    private DataSource dataSource;


    @Resource(name = "readDataSources")
    private List<DataSource> readDataSources;


    @Bean(name = "abstractRoutingDataSource")
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {
        DatasourceRouting proxy = new DatasourceRouting(1);
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();

        targetDataSources.put(DatasourceType.write.getType(),dataSource);
        targetDataSources.put(0, readDataSources.get(0));
        proxy.setDefaultTargetDataSource(dataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }


    @Bean
    public JdbcTemplate createJdbcTemplate(AbstractRoutingDataSource abstractRoutingDataSource){
        return new JdbcTemplate(abstractRoutingDataSource);
    }


}
