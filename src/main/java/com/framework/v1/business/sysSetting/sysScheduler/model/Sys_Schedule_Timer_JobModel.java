package com.framework.v1.business.sysSetting.sysScheduler.model;

import com.framework.v1.framework.database.base.BaseModel;
import org.quartz.Trigger;

public class Sys_Schedule_Timer_JobModel extends BaseModel {

    public Sys_Schedule_Timer_JobModel(){}

    private String id;
    private String job_name;
    private String job_group_name;
    private String trigger_name;
    private String trigger_group_name;
    private String cron;
    private String job_class ;
    private String time ;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getJob_group_name() {
        return job_group_name;
    }

    public void setJob_group_name(String job_group_name) {
        this.job_group_name = job_group_name;
    }

    public String getTrigger_name() {
        return trigger_name;
    }

    public void setTrigger_name(String trigger_name) {
        this.trigger_name = trigger_name;
    }

    public String getTrigger_group_name() {
        return trigger_group_name;
    }

    public void setTrigger_group_name(String trigger_group_name) {
        this.trigger_group_name = trigger_group_name;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getJob_class() {
        return job_class;
    }

    public void setJob_class(String job_class) {
        this.job_class = job_class;
    }

    public Class jobClassUrlToClass() throws ClassNotFoundException {
        String className=getJob_class();
        Class clazz = Class.forName(className);
        return clazz;
    }

    public static boolean isRunning(Trigger.TriggerState triggerState) {
        if(triggerState == Trigger.TriggerState.BLOCKED
                ||triggerState ==Trigger.TriggerState.NORMAL){
            return true;
        }else {
            return false;
        }
    }
}
