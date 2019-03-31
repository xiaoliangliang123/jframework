package com.framework.v1.business.sysSetting.sysUsers.controller;


import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsGroupService;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsGroupViewService;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_group_view")
public class PermsGroupViewController {

    @Autowired
    private PermsGroupViewService permsGroupViewService;

    @RequestMapping(name = "页面列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {


        //页面列表
        JsonResult jsonResult = permsGroupViewService.baseList();
        return jsonResult;
    }

    

}
