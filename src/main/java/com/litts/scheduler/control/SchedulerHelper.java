package com.litts.scheduler.control;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

@ApplicationScoped
public class SchedulerHelper {

  @Inject Scheduler quartz;

  public void scheduleOnce(
      final int initialDelay, Class<? extends Job> jobClass, JobDataMap jobDataMap)
      throws SchedulerException {

    JobDetail job =
        JobBuilder.newJob(jobClass)
            .withIdentity(
                "OnceOffJob" + System.currentTimeMillis(),
                "OnceOffJobGroup" + System.currentTimeMillis())
            .setJobData(jobDataMap)
            .build();

    Trigger trigger =
        TriggerBuilder.newTrigger()
            .withIdentity(
                "OnceOffTrigger" + System.currentTimeMillis(),
                "OnceOffGroup" + System.currentTimeMillis())
            .startNow()
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(initialDelay))
            .build();
    quartz.scheduleJob(job, trigger);
  }
}
