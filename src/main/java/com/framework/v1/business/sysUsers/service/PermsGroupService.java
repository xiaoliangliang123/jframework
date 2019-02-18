package com.framework.v1.business.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;

public interface PermsGroupService extends BaseQuery {
    JsonResult addOrEditPermsGroup(String uid, String permsGroupId, String permsGroupName) throws Exception;

    JsonResult removePermsGroup(String uid) throws Exception;

    JsonResult getPermsGroupInfo(String uid) throws Exception;
}
