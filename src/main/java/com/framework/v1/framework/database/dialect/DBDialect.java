package com.framework.v1.framework.database.dialect;


import com.framework.v1.business.base.service.PageInfo;

public abstract class DBDialect {

    public static final String DIALECT_MYSQL = "mysql";

    public static final String DIALECT_ORACLE = "oracle";

    protected PageInfo pageInfo;
    protected String sql ;
    protected String orderBySql;

    public String getOrderBySql() {
        return orderBySql;
    }

    public void setOrderBySql(String orderBySql) {
        this.orderBySql = orderBySql;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean isMyDo(String dialect){
       return myDialect().equals(dialect);
    }

    public abstract String myDialect();


    public abstract String pageSql();

}
