package com.framework.v1.business.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.sysUsers.model.Sys_UserModel;
import com.framework.v1.business.sysUsers.vo.UserVO;

public interface PermsUserService extends BaseQuery {

    public JsonResult addOrEditUser(String userid,String username,String nickname) throws Exception;


    JsonResult removeUser(String userId) throws Exception;

    JsonResult getUserinfo(String userId) throws Exception;

    Sys_UserModel getUserModelByUsername(String name) throws Exception;

    UserVO queryUserByUsername(String username) throws Exception;
}
