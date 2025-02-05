package com.andyadc.marketing.task;

import com.andyadc.codecraft.base.util.concurrent.ThreadUtils;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SchedulingTask {

	private static final Logger logger = LoggerFactory.getLogger(SchedulingTask.class);

	@SchedulerLock(name = "task001")
	@Scheduled(cron = "0/7 * * * * ?")
	public void task001() {
		logger.info("Task001 Starting - `0/7 * * * * ?` ");
		ThreadUtils.sleep(10L, TimeUnit.SECONDS);
		logger.info("Task001 Ended - `0/7 * * * * ?` ");
	}
}
