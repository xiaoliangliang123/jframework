package com.framework.v1.business.sysSetting.sysUsers.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsRoleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_perms_role_manager")
public class PermsRoleManagerController {


    @Autowired
    private PermsRoleManagerService permsRoleManagerService;

    @RequestMapping(name = "角色权限列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(String permsRoleId) throws Exception {

        return permsRoleManagerService.queryModulesForRoleId(permsRoleId);
    }

    @RequestMapping(name = "角色权限保存" ,value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(String permsRoleId,String[] permsRoleUrls) throws Exception {

        return permsRoleManagerService.savePermsRoleUrls(permsRoleId,permsRoleUrls);
    }
}
