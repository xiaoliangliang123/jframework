package com.framework.v1.framework.timer;

import com.framework.v1.framework.database.base.JBaseDao;
import com.framework.v1.framework.database.config.SpringUtil;
import com.framework.v1.framework.database.config.Sys_Schedule_Job_TimeModel;
import com.framework.v1.framework.util.GenerateUtil;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.BeanFactory;

public abstract class AbstractScheduleJob implements Job{

    private Logger logger = Logger.getLogger(AbstractScheduleJob.class);

    public static final String JOB_ID ="jobId";
    public static final String TYPE_NORMAL = "执行";
    public static final String STATE_SUCCESS = "成功";
    public static final String STATE_FAILED = "失败";

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        try{
                JobDetail jobDetail = jobExecutionContext.getJobDetail();
                JBaseDao jBaseDao =  SpringUtil.getObject(JBaseDao.class);
                Sys_Schedule_Job_TimeModel sysScheduleJobTimeModel  = new Sys_Schedule_Job_TimeModel();
                sysScheduleJobTimeModel.setId(GenerateUtil.uuid());
                sysScheduleJobTimeModel.setTime(GenerateUtil.currentTime());
                String jobId = (String) jobDetail.getJobDataMap().getString(JOB_ID);
                sysScheduleJobTimeModel.setJob_id(jobId);
                sysScheduleJobTimeModel.setExecute_type(TYPE_NORMAL);
                sysScheduleJobTimeModel.setResult(STATE_SUCCESS);
                sysScheduleJobTimeModel.setJob_class(jobDetail.getJobClass().getName());
                Long start = System.currentTimeMillis();
                this.doExecute(jobExecutionContext);
                Long end = System.currentTimeMillis();
                Long useTime = end -start ;
                sysScheduleJobTimeModel.setUse_time(useTime.toString());
                jBaseDao.insertModel(sysScheduleJobTimeModel);

        }catch (Exception e){
            try {
                JobDetail jobDetail = jobExecutionContext.getJobDetail();
                JBaseDao jBaseDao =  SpringUtil.getObject(JBaseDao.class);
                Sys_Schedule_Job_TimeModel sysScheduleJobTimeModel  = new Sys_Schedule_Job_TimeModel();
                sysScheduleJobTimeModel.setId(GenerateUtil.uuid());
                sysScheduleJobTimeModel.setTime(GenerateUtil.currentTime());
                String jobId = (String) jobDetail.getJobDataMap().getString(JOB_ID);
                sysScheduleJobTimeModel.setJob_id(jobId);
                sysScheduleJobTimeModel.setExecute_type(TYPE_NORMAL);
                sysScheduleJobTimeModel.setResult(STATE_FAILED);
                sysScheduleJobTimeModel.setJob_class(jobDetail.getJobClass().getName());
                jBaseDao.insertModel(sysScheduleJobTimeModel);
            }catch (Exception ex){
                logger.error(e.getMessage());
            }
            logger.error(e.getMessage());
        }



    }

    protected abstract void doExecute(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
