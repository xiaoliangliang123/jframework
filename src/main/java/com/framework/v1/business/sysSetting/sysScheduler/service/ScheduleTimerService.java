package com.framework.v1.business.sysSetting.sysScheduler.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;
import com.framework.v1.business.sysSetting.sysScheduler.model.Sys_Schedule_Timer_JobModel;

public interface ScheduleTimerService extends BaseQuery {


    JsonResult addOrEdit(Sys_Schedule_Timer_JobModel sysScheduleTimerJobModel) throws Exception;

    JsonResult startOrShutdownJob(String jobId) throws Exception;

    JsonResult startOrShutdownJobOnce(String jobId,Integer count) throws Exception;

    JsonResult removeScheduleTimerById(String jobId) throws Exception;

    JsonResult getScheduleJobByJobId(String jobId) throws Exception;
}
