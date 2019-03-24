package com.framework.v1.framework.timer;


import org.junit.Test;

public class SchedulerTester {



    @Test
    public void testCronTrigger() throws InterruptedException {


        String jobName = "测试job";
        String jobGroupName = "测试job组";
        String triggerName = "测试触发器";
        String triggerGroupName = "测试触发器组";
        Class jobClass  = SchedulerTestJob.class;
        String cron = "*/2 * * * * ?";
        SchedulerUtil.getScheduler().hadleCronTrigger(jobName,jobGroupName,triggerName,triggerGroupName,jobClass,cron);
        Thread.sleep(300000);

    }

    @Test
    public void testInvokeTrigger() throws InterruptedException {


        String jobName = "测试job";
        String jobGroupName = "测试job组";
        String triggerName = "测试触发器";
        String triggerGroupName = "测试触发器组";
        Class jobClass  = SchedulerTestJob.class;
        String cron = "*/2 * * * * ?";
        SchedulerUtil.getScheduler().hadleInvokeTrigger(jobName,jobGroupName,triggerName,triggerGroupName,jobClass,cron,3);
        Thread.sleep(  10000);

    }

    @Test
    public void testCronTriggers() throws InterruptedException {


        String jobName = "测试job";
        String jobGroupName = "测试job组";
        String triggerNames[] = new String[]{"测试触发器1","测试触发器2"};
        String triggerGroupNames[] = new String[]{"测试触发器组","测试触发器组"};
        Class jobClass  = SchedulerTestJob.class;
        String cron[] = new String[]{ "*/5 * * * * ?","*/6 * * * * ?"};
        SchedulerUtil.getScheduler().hadleCronTriggers(jobName,jobGroupName,triggerNames,triggerGroupNames,jobClass,cron);
        Thread.sleep(300000);

    }

    @Test
    public void testTimerTrigger() throws InterruptedException {


        String jobName = "测试job";
        String jobGroupName = "测试job组";
        String triggerName = "测试触发器";
        String triggerGroupName = "测试触发器组";
        Class jobClass  = SchedulerTestJob.class;
        int time = 1;
        int count = 5;
        SchedulerUtil.getScheduler().handleSimpleTrigger(jobName,jobGroupName,triggerName,triggerGroupName,jobClass,time,count);
        //Thread.sleep(20000);
        //SchedulerUtil.removeJob(jobName,jobGroupName,triggerName,triggerGroupName);
        Thread.sleep(300000);
    }
}
