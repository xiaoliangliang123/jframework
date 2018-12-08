package com.framework.v1.business.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;
import com.framework.v1.business.base.service.BaseService;

public interface UserService extends BaseQuery {

    public JsonResult addOrEditUser(String userid,String username, String password) throws Exception;


    JsonResult removeUser(String userId) throws Exception;

    JsonResult getUserinfo(String userId) throws Exception;

}
