package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.service.PermsGroupRoleService;
import org.springframework.stereotype.Component;

@Component
public class PermsGroupRoleServiceImpl  extends BaseServiceAdapter implements PermsGroupRoleService {



    @Override
    public String baseQuery() {


        return "select * from sys_perms_role ";
    }
}
