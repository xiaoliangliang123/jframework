package com.framework.v1.business.sysSetting.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;

public interface PermsRoleManagerService   extends   BaseQuery {


    JsonResult queryModulesForRoleId(String permsRoleId) throws Exception;

    JsonResult savePermsRoleUrls(String permsRoleId, String[] permsRoleUrls);
}
