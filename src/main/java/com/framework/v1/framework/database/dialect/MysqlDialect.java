package com.framework.v1.framework.database.dialect;

import com.framework.v1.business.base.service.PageInfo;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.stereotype.Component;

@Component
public class MysqlDialect extends DBDialect{


    @Override
    public String myDialect() {
        return DIALECT_MYSQL;
    }

    @Override
    public String pageSql() {

        if(!StringUtil.isEmpty(orderBySql)){
            return sql +" "+orderBySql+" limit "+getStart() +" , "+ pageInfo.getPageSize();
        }
        return sql +" limit "+getStart() +" , "+ pageInfo.getPageSize();
    }

    public Integer getStart() {
        return (pageInfo.getCurrentPage()-1)*pageInfo.getPageSize();
    }


    public int getNoSqlStart() {

        return (pageInfo.getCurrentPage()-1)*pageInfo.getPageSize()<=0 ?0:(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize();
    }

    @Override
    public int getNoSqlEnd(int totalCount) {
        Integer count =  pageInfo.getCurrentPage()*pageInfo.getPageSize();
        return count>=totalCount?totalCount:count;
    }


}
