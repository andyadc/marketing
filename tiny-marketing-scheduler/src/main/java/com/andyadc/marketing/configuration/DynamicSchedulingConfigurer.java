package com.andyadc.marketing.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

//@Configuration
public class DynamicSchedulingConfigurer implements SchedulingConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(DynamicSchedulingConfigurer.class);

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		String cron = "0/3 * * * * ?";
		Runnable task = () -> logger.info("-------------");
		CronTask cronTask = new CronTask(task, cron);

		taskRegistrar.addCronTask(cronTask);

		taskRegistrar.addTriggerTask(
			() -> {

			},
			triggerContext -> {
				CronTrigger cronTrigger = new CronTrigger(cron);
				Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
				logger.info("NextExecutionTime -> {}", nextExecutionTime);
				return nextExecutionTime;
			}
		);
	}
}
