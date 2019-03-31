package com.framework.v1.business.sysSetting.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_Perms_GroupModel;

public interface PermsGroupService extends BaseQuery {
    JsonResult addOrEditPermsGroup(Sys_Perms_GroupModel sys_perms_groupModel) throws Exception;

    JsonResult removePermsGroup(String uid) throws Exception;

    JsonResult getPermsGroupInfo(String uid) throws Exception;

    Sys_Perms_GroupModel getSysPermsModel(String permsGroupId) throws Exception;

    JsonResult queryTopModuleList() throws Exception;

    JsonResult queryTopGroupListByParentId(String parentId);
}
