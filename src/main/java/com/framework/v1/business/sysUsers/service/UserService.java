package com.framework.v1.business.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;

public interface UserService {

    public JsonResult addUser(String username, String password) throws Exception;

    JsonResult listUser(String username);

    JsonResult baseList();
}
