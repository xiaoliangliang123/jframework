package com.framework.v1.business.base.service;

import com.framework.v1.framework.database.config.SpringUtil;
import com.framework.v1.framework.database.config.SysConfigBean;
import com.framework.v1.framework.database.dialect.DBDialect;
import com.framework.v1.framework.database.dialect.DBDialectUtil;
import com.framework.v1.framework.util.StringUtil;
import net.sf.json.JSONObject;

import java.util.Map;

public class PageInfo {

    public static final String PAGE_INFO_KEY = "pageInfo";

    public static final String TOTAL_COUNT_KEY = "totalCount";

    public static final String CURRENT_PAGE_KEY = "currentPage";

    public static final String PAGE_SIZE_KEY = "pageSize";
    private Integer totalCount = 0;
    private Integer pageSize = 0;
    private Integer currentPage = 0;
    private DBDialect dbDialect;

    public DBDialect getDbDialect() {
        return dbDialect;
    }

    public void setDbDialect(DBDialect dbDialect) {
        this.dbDialect = dbDialect;
    }

    public PageInfo() {
    }

    public PageInfo(Integer totalCount, Integer pageSize, Integer currentPage) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currentPage = currentPage;

    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public static PageInfo init(Map map) {

        DBDialectUtil dBDialectUtil =  SpringUtil.getObject(DBDialectUtil.class);
        if (map.containsKey(PAGE_INFO_KEY)) {
            String pinfo[] = (String[]) map.get(PAGE_INFO_KEY);
            if (pinfo != null && pinfo.length > 0) {
                JSONObject jsonObject = JSONObject.fromObject(pinfo[0]);
                Map m = jsonObject;
                Integer pageSize = Integer.parseInt(m.get(PAGE_SIZE_KEY).toString());
                Integer currentPage = Integer.parseInt(m.get(CURRENT_PAGE_KEY).toString());
                PageInfo pageInfo = new PageInfo(0, pageSize, currentPage);
                return pageInfo;
            }
        }
        return new PageInfo();
    }

    public static Integer initCount(Integer totalCount) {
        if (totalCount <= 0) {
            return totalCount;
        }
        return totalCount;
    }

    public String toLimitSql(String sql, String orderBySql) {

        DBDialectUtil dBDialectUtil = (DBDialectUtil) SpringUtil.getObject(DBDialectUtil.class);
        dbDialect = dBDialectUtil.getDbDialect(SysConfigBean.getDatabaseType());
        dbDialect.setSql(sql);
        dbDialect.setPageInfo(this);
        dbDialect.setOrderBySql(orderBySql);
        String limitSql = dbDialect.pageSql();//sql +" limit "+getStart() +" , "+ getPageSize();
        return limitSql;
    }


    public int getNoSqlStart() {
        return (getCurrentPage()-1)*getPageSize()<=0 ?0:(getCurrentPage()-1)*getPageSize();

    }

    public int getNoSqlEnd(int totalCount) {

        Integer count =  getCurrentPage()*getPageSize();
        return count>=totalCount?totalCount:count;    }
}
