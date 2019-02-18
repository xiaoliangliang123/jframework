package com.framework.v1.business.sysUsers.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysUsers.service.PermsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_perms_group")
public class PermsGroupController {

    @Autowired
    private PermsGroupService permsGroupService;

    @RequestMapping(name = "权限集列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {


        //权限集列表
        JsonResult jsonResult = permsGroupService.baseList();
        return jsonResult;
    }

    @RequestMapping(name = "添加或编辑权限集合" ,value = "/addOrEdit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addOrEdit(String uid,String permsGroupId,String permsGroupName) throws Exception {


        //添加新系统权限集合
        JsonResult jsonResult = permsGroupService.addOrEditPermsGroup(uid,permsGroupId,permsGroupName);
        return jsonResult;
    }

    @RequestMapping(name = "删除权限集合" ,value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult del(String uid) throws Exception {



        //删除权限集合
        JsonResult jsonResult = permsGroupService.removePermsGroup(uid);
        return jsonResult;
    }

    @RequestMapping(name = "编辑权限集合" ,value = "/getPermsGroupInfo",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPermsGroupInfo(String uid) throws Exception {

        //编辑权限集合
        JsonResult jsonResult = permsGroupService.getPermsGroupInfo(uid);
        return jsonResult;
    }




}
