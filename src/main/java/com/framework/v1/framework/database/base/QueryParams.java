package com.framework.v1.framework.database.base;

public class QueryParams {


    private String querySql ;
    private String orderBySql;



    public QueryParams(){

    }

    public QueryParams(String querySql, String orderBySql) {
        this.querySql = querySql;
        this.orderBySql = orderBySql;
    }

    public String getOrderBySql() {
        return orderBySql;
    }

    public String getQuerySql() {
        return querySql;
    }
}
