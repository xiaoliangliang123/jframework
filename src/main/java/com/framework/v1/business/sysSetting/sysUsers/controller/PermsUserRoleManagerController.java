package com.framework.v1.business.sysSetting.sysUsers.controller;


import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsUserRoleManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys_perms_user_role_manager")
public class PermsUserRoleManagerController {


    @Resource
    private PermsUserRoleManagerService permsUserRoleManagerService;

    @RequestMapping(name = "用户角色列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(String permsUserId) throws Exception {

        return permsUserRoleManagerService.queryRolesForUserId(permsUserId);
    }


    @RequestMapping(name = "用户角色保存" ,value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(String permsUserId,String[] permsRoleIds) throws Exception {

        return permsUserRoleManagerService.savePermsUserRoles(permsUserId,permsRoleIds);
    }

}
