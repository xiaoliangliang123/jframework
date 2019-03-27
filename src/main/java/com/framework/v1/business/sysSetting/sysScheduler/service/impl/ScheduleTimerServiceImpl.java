package com.framework.v1.business.sysSetting.sysScheduler.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysSetting.sysScheduler.model.Sys_Schedule_Timer_JobModel;
import com.framework.v1.business.sysSetting.sysScheduler.service.ScheduleTimerService;
import com.framework.v1.framework.database.base.QueryParams;
import com.framework.v1.framework.timer.JobState;
import com.framework.v1.framework.timer.SchedulerUtil;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

@Component
public class ScheduleTimerServiceImpl   extends BaseServiceAdapter implements ScheduleTimerService {

    @Override
    public QueryParams baseQuery() {
        return new QueryParams(" select * from sys_schedule_timer_job  "," order by time desc ");
    }


    @Override
    public JsonResult baseList() throws Exception {
        JsonResult jsonResult =  super.baseList();
        List<Map> mapList = DataUtil.insertRowIntoMapList("state",JobState.STATE_SHUTDOWN+"",(List<Map>)jsonResult.get("data"));
        mapList = setStateInMapList(mapList);
        jsonResult.setData(mapList);
        return jsonResult;
    }

    public List<Map> setStateInMapList(List<Map> mapList) throws Exception {
        if(StringUtil.isEmpty(mapList)){
            return null;
        }
        for(int i = 0 ; i < mapList.size(); i++ ){
            Map map = mapList.get(i);
            Sys_Schedule_Timer_JobModel scheduleTimerJobModel = DataUtil.copyMap2Bean(map,Sys_Schedule_Timer_JobModel.class);
            Trigger.TriggerState state = SchedulerUtil.getScheduler().getJobTriggerState(new JobKey(scheduleTimerJobModel.getJob_name(),scheduleTimerJobModel.getJob_group_name()));
            boolean isRunning =  Sys_Schedule_Timer_JobModel.isRunning(state);
            map.put("state",JobState.initState(isRunning).getState());
        }
        return mapList;

    }

    @Override
    public JsonResult addOrEdit(Sys_Schedule_Timer_JobModel sysScheduleTimerJobModel) throws Exception {

        if(StringUtil.isEmpty(sysScheduleTimerJobModel.getId())){

            sysScheduleTimerJobModel.setId(GenerateUtil.uuid());
            sysScheduleTimerJobModel.setTime(GenerateUtil.currentTime());
            getjBaseDao().insertModel(sysScheduleTimerJobModel);

        }else {
            sysScheduleTimerJobModel.setTime(GenerateUtil.currentTime());
            getjBaseDao().updateModel(sysScheduleTimerJobModel);
        }
        return new JsonResult("保存成功");
    }

    @Override
    public JsonResult startOrShutdownJob(String jobId) throws Exception {

        Sys_Schedule_Timer_JobModel scheduleTimerJobModel = new Sys_Schedule_Timer_JobModel();
        scheduleTimerJobModel.setId(jobId);
        scheduleTimerJobModel = (Sys_Schedule_Timer_JobModel)getjBaseDao().selectModel(scheduleTimerJobModel);
        Class jobClass =  scheduleTimerJobModel.jobClassUrlToClass();
        Trigger.TriggerState triggerState = SchedulerUtil.getScheduler().getJobTriggerState(new JobKey(scheduleTimerJobModel.getJob_name(),scheduleTimerJobModel.getJob_group_name()));
        if(!scheduleTimerJobModel.isRunning(triggerState)){
            SchedulerUtil.getScheduler().hadleCronTrigger(jobId,scheduleTimerJobModel.getJob_name(),scheduleTimerJobModel.getJob_group_name(),scheduleTimerJobModel.getTrigger_name(),scheduleTimerJobModel.getTrigger_group_name(),jobClass,scheduleTimerJobModel.getCron());
            return new JsonResult(true,"任务启动成功", JobState.initState(JobState.STATE_RUNNING));
        }else {
            SchedulerUtil.getScheduler().removeJob(jobId,scheduleTimerJobModel.getJob_name(),scheduleTimerJobModel.getJob_group_name(),scheduleTimerJobModel.getTrigger_name(),scheduleTimerJobModel.getTrigger_group_name());
            return new JsonResult(true,"任务停止成功",JobState.initState(JobState.STATE_SHUTDOWN));
        }
    }

    @Override
    public JsonResult startOrShutdownJobOnce(String jobId,Integer count) throws Exception {

        Sys_Schedule_Timer_JobModel scheduleTimerJobModel = new Sys_Schedule_Timer_JobModel();
        scheduleTimerJobModel.setId(jobId);
        scheduleTimerJobModel = (Sys_Schedule_Timer_JobModel)getjBaseDao().selectModel(scheduleTimerJobModel);
        Class jobClass =  scheduleTimerJobModel.jobClassUrlToClass();
        Trigger.TriggerState triggerState = SchedulerUtil.getScheduler().getJobTriggerState(new JobKey(scheduleTimerJobModel.getJob_name(),scheduleTimerJobModel.getJob_group_name()));
        SchedulerUtil.getScheduler().hadleInvokeTrigger(jobId,scheduleTimerJobModel.getJob_name(),scheduleTimerJobModel.getJob_group_name(),scheduleTimerJobModel.getTrigger_name(),scheduleTimerJobModel.getTrigger_group_name(),jobClass,scheduleTimerJobModel.getCron(),count);
        return new JsonResult(true,"任务启动成功", JobState.initState(JobState.STATE_RUNNING));

    }

    @Override
    public JsonResult removeScheduleTimerById(String jobId) throws Exception {

        Sys_Schedule_Timer_JobModel scheduleTimerJobModel = new Sys_Schedule_Timer_JobModel();
        scheduleTimerJobModel.setId(jobId);
        getjBaseDao().deleteModel(scheduleTimerJobModel);
        return new JsonResult("删除任务成功");
    }

    @Override
    public JsonResult getScheduleJobByJobId(String jobId) throws Exception {
        Sys_Schedule_Timer_JobModel scheduleTimerJobModel = new Sys_Schedule_Timer_JobModel();
        scheduleTimerJobModel.setId(jobId);
        scheduleTimerJobModel =  (Sys_Schedule_Timer_JobModel)getjBaseDao().selectModel(scheduleTimerJobModel);
        return new JsonResult(scheduleTimerJobModel);
    }
}
