package com.framework.v1.business.sysSetting.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;

public interface PermsGroupRoleService extends BaseQuery {

    JsonResult addOrEditPermsRole(String uid, String roleId, String roleName) throws Exception;

    JsonResult getPermsRoleInfoForId(String roleId) throws Exception;

    JsonResult removePermsGroupRole(String id) throws Exception;
}
