package com.andyadc.marketing.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingTask {

	private static final Logger logger = LoggerFactory.getLogger(SchedulingTask.class);

	@Scheduled(cron = "0/7 * * * * ?")
	public void task001() {
		logger.info("task001");
	}

	@Scheduled(fixedDelay = 3000L, initialDelay = 10000L)
	public void task002() {
		logger.info("task002");
	}
}
