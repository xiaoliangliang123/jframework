package com.framework.v1.framework.timer;

import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

/**
 * [说明/描述]
 * @author Edon-Du
 * @date 2018-6-25
 * @version 1.0
 * @copyright copyright (c) 2018
 */
public class SchedulerUtil {


    public static final String SCHEDULE_NAME = "schedule_name";

    private SchedulerFactory schedulerfactory =new StdSchedulerFactory();
    private static Logger _logger = Logger.getLogger(SchedulerUtil.class);// log4j记录日志
    private static SchedulerUtil schedulerUtil = new SchedulerUtil();

    public static SchedulerUtil getScheduler(){
        return  schedulerUtil;
    }
    /**
     *
     * [简单任务调度:每次执行间隔为多少毫秒，执行多少次] <br>
     * @author Edon-Du <br>
     * @date 2018-6-25 <br>
     * @param jobName 任务名字
     * @param jobGroupName 任务组名字
     */
    public  void handleSimpleTrigger(String jobName, String jobGroupName,
                                           String triggerName, String triggerGroupName, Class jobClass,
                                           int time, int count) {

        Scheduler scheduler = null;
        try {
            // 通过schedulerFactory获取一个调度器

            scheduler = schedulerfactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroupName).build();
            // 定义调度触发规则
            //使用simpleTrigger规则
            Trigger
                    trigger=TriggerBuilder.newTrigger().withIdentity(triggerName,
                    triggerGroupName)
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(time).withRepeatCount(count))
                    .build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            // 启动调度
            scheduler.start();
            System.out.println("开始时间："+ GenerateUtil.currentTime());
        } catch (Exception e) {
            _logger.warn("执行"+jobGroupName+"组"+jobName+"任务出现异常E:["+ e.getMessage() + "]");
        }
    }
    /**
     * [复杂任务调度：每天几点几分几秒定时执行任务] <br>
     * @author Edon-Du <br>
     * @date 2018-6-25 <br>
     * @param jobName 任务名字
     * @param jobGroupName 任务组名字
     * @param triggerName 触发器名字
     * @param triggerGroupName 触发器组名字
     * @param jobClass 任务类
     * @param cron 触发规则<br>
     */
    public  void hadleCronTrigger(String jobName, String jobGroupName,
                                        String triggerName, String triggerGroupName, Class jobClass,String cron) {

        Scheduler scheduler = null;
        try {
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();

            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroupName).build();
            // 定义调度触发规则

            //使用cornTrigger规则  每天18点30分
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            // 启动调度
            scheduler.start();

        } catch (Exception e) {
            _logger.warn("执行"+jobName+"组"+jobName+"任务出现异常E:["+ e.getMessage() + "]");
        }
    }


    /**
     * [复杂任务调度：每天几点几分几秒定时执行任务] <br>
     * @author Edon-Du <br>
     * @date 2018-6-25 <br>
     * @param jobName 任务名字
     * @param jobGroupName 任务组名字
     * @param triggerName 触发器名字
     * @param triggerGroupName 触发器组名字
     * @param jobClass 任务类
     * @param cron 触发规则<br>
     */
    public  void hadleInvokeTrigger(String jobName, String jobGroupName,
                                  String triggerName, String triggerGroupName, Class jobClass,String cron,Integer count) {

        try {
            String random = GenerateUtil.uuid();
            handleSimpleTrigger(jobName+"_"+random,jobGroupName+"_"+random,triggerName+"_"+random,triggerGroupName+"_"+random,jobClass,1,count);
        } catch (Exception e) {
            _logger.warn("执行"+jobName+"组"+jobName+"任务出现异常E:["+ e.getMessage() + "]");
        }
    }


    /**
     * [复杂任务调度：每天几点几分几秒定时执行任务] <br>
     * @author Edon-Du <br>
     * @date 2018-6-25 <br>
     * @param jobName 任务名字
     * @param jobGroupName 任务组名字
     * @param triggerNames 触发器数组名字
     * @param triggerGroupNames 触发器组数组名字
     * @param jobClass 任务类
     * @param crons 触发规则数组<br>
     */
    public  void hadleCronTriggers(String jobName, String jobGroupName,
                                        String[] triggerNames, String[] triggerGroupNames, Class jobClass,String[] crons) {

        Scheduler scheduler = null;
        try {

            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();

            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroupName).storeDurably().build();

            scheduler.addJob(job, true);
            for(int i = 0 ; i < triggerNames.length;i++) {
                // 定义调度触发规则
                //使用cornTrigger规则  每天18点30分
                Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerNames[i], triggerGroupNames[i])
                        .withSchedule(CronScheduleBuilder.cronSchedule(crons[i]))
                        .forJob(job)
                        .build();
                // 把作业和触发器注册到任务调度中
                scheduler.scheduleJob(trigger);
            }
            // 启动调度
            scheduler.start();

        } catch (Exception e) {
            _logger.warn("执行"+jobName+"组"+jobName+"任务出现异常E:["+ e.getMessage() + "]");
        }
    }

    public  void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName) {
        try {
            Scheduler sched = schedulerfactory.getScheduler();
            TriggerKey triggerKey =  new TriggerKey(triggerName,triggerGroupName);
            sched.pauseTrigger(triggerKey);// 停止触发器
            sched.unscheduleJob(triggerKey);// 移除触发器
            sched.deleteJob(new JobKey(jobName, jobGroupName));// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  Trigger.TriggerState getJobTriggerState(JobKey key) throws SchedulerException {


        Scheduler sched = schedulerfactory.getScheduler();
        List<Trigger> triggers = (List<Trigger>) sched.getTriggersOfJob(key);
        if(StringUtil.isEmpty(triggers)){
            return Trigger.TriggerState.NONE;
        }
        return sched.getTriggerState(triggers.get(0).getKey());
    }
}
