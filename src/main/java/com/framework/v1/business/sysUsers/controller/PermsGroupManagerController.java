package com.framework.v1.business.sysUsers.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysUsers.service.PermsGroupManagerService;
import com.framework.v1.business.sysUsers.service.PermsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_perms_group_manager")
public class PermsGroupManagerController {


    @Autowired
    private PermsGroupManagerService permsGroupManagerService;

    @RequestMapping(name = "权限集管理" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {


        //权限集列表
        JsonResult jsonResult = permsGroupManagerService.baseList();
        return jsonResult;
    }
}
