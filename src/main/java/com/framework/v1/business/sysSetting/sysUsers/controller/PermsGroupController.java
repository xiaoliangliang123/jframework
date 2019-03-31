package com.framework.v1.business.sysSetting.sysUsers.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysSetting.sysScheduler.model.Sys_Schedule_Timer_JobModel;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_perms_group")
public class PermsGroupController {

    @Autowired
    private PermsGroupService permsGroupService;

    @RequestMapping(name = "模块列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {


        //权限集列表
        JsonResult jsonResult = permsGroupService.baseList();
        return jsonResult;
    }

    @RequestMapping(name = "一级权模块列表" ,value = "/topList",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult topModulelist() throws Exception {


        //一级权模块列表
        JsonResult jsonResult = permsGroupService.queryTopModuleList();
        return jsonResult;
    }

    @RequestMapping(name = "二级模块列表" ,value = "/groupsList",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult topModulelist(String parentId) throws Exception {


        //二技权限集列表
        JsonResult jsonResult = permsGroupService.queryTopGroupListByParentId(parentId);
        return jsonResult;
    }

    @RequestMapping(name = "添加或编辑权限集合" ,value = "/addOrEdit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addOrEdit(@ModelAttribute Sys_Perms_GroupModel sys_perms_groupModel) throws Exception {


        //添加新系统权限集合
        JsonResult jsonResult = permsGroupService.addOrEditPermsGroup(sys_perms_groupModel);
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
