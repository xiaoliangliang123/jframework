package com.framework.v1.business.sysSetting.sysUsers.controller;


import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_perms")
public class PermsController {

    @Autowired
    private PermsService permsService;

    @RequestMapping(name = "权限列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {


        //权限列表
        JsonResult jsonResult = permsService.baseList();
        return jsonResult;
    }

    @RequestMapping(name = "权限集管理" ,value = "/permsGroup",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult permsGroup() throws Exception {


        //权限列表
        JsonResult jsonResult = permsService.baseList();
        return jsonResult;
    }


}
