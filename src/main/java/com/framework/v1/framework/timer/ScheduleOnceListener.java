package com.framework.v1.framework.timer;

import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class ScheduleOnceListener implements TriggerListener {

    private Integer count = 1 ;
    private Integer current = 1;

    public ScheduleOnceListener(Integer count){
        this.count =count;
    }

    @Override
    public String getName() {
        return "ScheduleOnceListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {

        String name =  context.getJobDetail().getKey().getName();
        Integer count = (Integer) context.getJobDetail().getJobDataMap().get(name+"count");
        System.out.println("调用次数:"+current);
        if(current == count){
            try {
                context.getScheduler().shutdown();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }else {
            current ++;
        }
    }
}
