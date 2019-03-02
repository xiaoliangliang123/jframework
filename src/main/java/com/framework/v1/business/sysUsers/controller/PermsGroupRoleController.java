package com.framework.v1.business.sysUsers.controller;


import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysUsers.service.PermsGroupRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys_perms_role")
public class PermsGroupRoleController {


    @Resource
    private PermsGroupRoleService permsGroupRoleService;

    @RequestMapping(name = "角色列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {

        //权限列表
        JsonResult jsonResult = permsGroupRoleService.baseList();
        return jsonResult;
    }


    @RequestMapping(name = "获取角色信息" ,value = "/getPermsRoleInfo",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPermsRoleInfo(String id) throws Exception {

        //角色信息
        JsonResult jsonResult = permsGroupRoleService.getPermsRoleInfoForId(id);
        return jsonResult;
    }

    @RequestMapping(name = "添加或编辑角色" ,value = "/addOrEdit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addOrEdit(String id,String roleId,String roleName) throws Exception {


        //添加新系统权限集合
        JsonResult jsonResult = permsGroupRoleService.addOrEditPermsRole(id,roleId,roleName);
        return jsonResult;
    }

    @RequestMapping(name = "删除权限" ,value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult del(String id) throws Exception {



        //删除权限集合
        JsonResult jsonResult = permsGroupRoleService.removePermsGroupRole(id);
        return jsonResult;
    }
}
