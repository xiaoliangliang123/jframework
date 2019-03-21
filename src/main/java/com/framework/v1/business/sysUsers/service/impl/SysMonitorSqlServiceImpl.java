package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.service.PermsUserService;
import com.framework.v1.business.sysUsers.service.SysMonitorSqlService;
import com.framework.v1.framework.database.base.QueryParams;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
public class SysMonitorSqlServiceImpl extends BaseServiceAdapter implements SysMonitorSqlService {

    @Override
    public QueryParams baseQuery() {


        return new QueryParams(" select * from sys_monitor_sql  "," order by time desc ");
    }
}
