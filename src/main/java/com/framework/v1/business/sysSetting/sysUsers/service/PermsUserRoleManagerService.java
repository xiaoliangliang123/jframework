package com.framework.v1.business.sysSetting.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;

public interface PermsUserRoleManagerService {


    public JsonResult savePermsUserRoles(String permsRoleId, String[] permsRoleIds);

     JsonResult queryRolesForUserId(String permsRoleId) throws Exception;
}
