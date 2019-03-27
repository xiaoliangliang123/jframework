package com.framework.v1.framework.timer;

import com.framework.v1.framework.util.GenerateUtil;
import org.quartz.*;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class SchedulerTestJob extends AbstractScheduleJob {


    @Override
    protected void doExecute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            JobDetail jobDetail = jobExecutionContext.getJobDetail();
            System.out.println("test echedule job , job state:" + SchedulerUtil.getScheduler().getJobTriggerState(jobDetail.getKey()).name() + " , time :" + GenerateUtil.currentTime());
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }


}
