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



    @RequestMapping(name = "添加或编辑权限集合" ,value = "/addOrEdit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addOrEdit(String uid,String roleId,String roleName) throws Exception {


        //添加新系统权限集合
        JsonResult jsonResult = permsGroupRoleService.addOrEditPermsRole(uid,roleId,roleName);
        return jsonResult;
    }
}
