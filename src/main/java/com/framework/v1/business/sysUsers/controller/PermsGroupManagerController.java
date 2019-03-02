package com.framework.v1.business.sysUsers.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysUsers.dto.PermissionGroupManagerDTO;
import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysUsers.service.PermsGroupManagerService;
import com.framework.v1.business.sysUsers.service.PermsGroupService;
import com.framework.v1.framework.requestMapping.Permission;
import com.framework.v1.framework.requestMapping.RequestMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sys_perms_group_manager")
public class PermsGroupManagerController {


    @Autowired
    private PermsGroupService permsGroupService;

    @Resource
    private RequestMappingUtil requestMappingUtil;
    @Autowired
    private PermsGroupManagerService permsGroupManagerService;

    @RequestMapping(name = "权限集管理" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(String permsGroupId) throws Exception {



        //权限集列表
        List<Permission> permissions = requestMappingUtil.getPermissions();
        Sys_Perms_GroupModel sysPermsGroupModel = (Sys_Perms_GroupModel)permsGroupService.getSysPermsModel(permsGroupId);

        List<String> urls =permsGroupManagerService.queryPermsModuleUrlsWith(permsGroupId);
        PermissionGroupManagerDTO permissionGroupManager = new PermissionGroupManagerDTO(sysPermsGroupModel,permissions,urls);
        return new JsonResult(permissionGroupManager);
    }


    @RequestMapping(name = "权限集保存" ,value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(String permsGroupId,String permsUrlValues) throws Exception {


        return permsGroupManagerService.savePermsGroupUrls(permsGroupId,permsUrlValues);
    }
}
