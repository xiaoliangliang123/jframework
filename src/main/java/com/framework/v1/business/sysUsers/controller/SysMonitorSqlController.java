package com.framework.v1.business.sysUsers.controller;


import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysUsers.service.SysMonitorSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_monitor_sql")
public class SysMonitorSqlController {


    @Autowired
    private SysMonitorSqlService sysMonitorSqlService;

    @RequestMapping(name = "sql日志列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {

        JsonResult jsonResult = sysMonitorSqlService.baseList();
        return jsonResult;
    }

}
