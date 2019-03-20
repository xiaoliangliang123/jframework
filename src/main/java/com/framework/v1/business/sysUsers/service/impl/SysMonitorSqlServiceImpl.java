package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.service.PermsUserService;
import com.framework.v1.business.sysUsers.service.SysMonitorSqlService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
public class SysMonitorSqlServiceImpl extends BaseServiceAdapter implements SysMonitorSqlService {

    @Override
    public String baseQuery() {


        return " select * from sys_monitor_sql  ";
    }
}
