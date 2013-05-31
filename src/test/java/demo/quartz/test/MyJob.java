package demo.quartz.test;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail jobDetail = context.getJobDetail();
		System.out.println("job:"+jobDetail.getKey().getName()+",group:"+jobDetail.getKey().getGroup()+";trigger:"+context.getTrigger().getKey().getName());
	}

}
