package com.andyadc.codecraft.base.quartz;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ScheduledFuture;

public class TaskSchedulerService {

	private TaskScheduler taskScheduler;

	public void scheduleTask() {

		Runnable taskRunnable = () -> {

		};

		CronTrigger trigger = new CronTrigger("");
		ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(taskRunnable, trigger);

	}

}
