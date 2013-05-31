package demo.quartz.test;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz2Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();

		JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
				.withIdentity("myjob", "myjobGroup").build();
		// 每五秒重复一次
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("simpleTrigger", "myjobGroup")
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(5).repeatForever())
			
								.build();

		JobDetail jobDetail2 = JobBuilder.newJob(MyJob.class)
				.withIdentity("myjob2", "myjobGroup2").build();
		
		// cron表达式
		Trigger cronTrigger = TriggerBuilder
				.newTrigger()
				.withIdentity("cronTrigger", "myjobGroup2")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
				.build();
		
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.scheduleJob(jobDetail2, cronTrigger);
		scheduler.start();

	}

}
