package com.framework.v1.business.sysSetting.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;

import java.util.List;

public interface PermsGroupManagerService extends BaseQuery {


    List<String> queryPermsModuleUrlsWith(String permsGroupId);

    JsonResult savePermsGroupUrls(String permsGroupId, String permsUrlValues);
}
