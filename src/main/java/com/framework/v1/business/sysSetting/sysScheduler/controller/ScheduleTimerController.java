package com.framework.v1.business.sysSetting.sysScheduler.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysSetting.sysMonitor.service.SysMonitorSqlService;
import com.framework.v1.business.sysSetting.sysScheduler.model.Sys_Schedule_Timer_JobModel;
import com.framework.v1.business.sysSetting.sysScheduler.service.ScheduleTimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/sys_schedule_timer")
public class ScheduleTimerController {

    @Autowired
    private ScheduleTimerService scheduleTimerService;

    @RequestMapping(name = "定时任务列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {

        JsonResult jsonResult = scheduleTimerService.baseList();
        return jsonResult;
    }

    @RequestMapping(name = "保存或者编辑任务" ,value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(@ModelAttribute Sys_Schedule_Timer_JobModel sysScheduleTimerJobModel) throws Exception {

        JsonResult jsonResult = scheduleTimerService.addOrEdit(sysScheduleTimerJobModel);
        return jsonResult;
    }

    @RequestMapping(name = "启动或者关闭任务" ,value = "/startOrShutdown",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult startOrShutdownJob(String jobId) throws Exception {


        JsonResult jsonResult = scheduleTimerService.startOrShutdownJob(jobId);
        return jsonResult;
    }

    @RequestMapping(name = "立即执行任务" ,value = "/startOrShutdownOnce",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult startOrShutdownJobOnce(String jobId,Integer count) throws Exception {


        JsonResult jsonResult = scheduleTimerService.startOrShutdownJobOnce(jobId,count);
        return jsonResult;
    }

    @RequestMapping(name = "获取定时任务信息" ,value = "/getScheduleJob",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getScheduleJob(String jobId) throws Exception {


        JsonResult jsonResult = scheduleTimerService.getScheduleJobByJobId(jobId);
        return jsonResult;
    }

    @RequestMapping(name = "删除任务" ,value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult del(String jobId) throws Exception {



        //删除权限集合
        JsonResult jsonResult = scheduleTimerService.removeScheduleTimerById(jobId);
        return jsonResult;
    }


}
