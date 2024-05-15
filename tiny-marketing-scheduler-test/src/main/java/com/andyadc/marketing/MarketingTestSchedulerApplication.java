package com.andyadc.marketing;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MarketingTestSchedulerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MarketingTestSchedulerApplication.class)
			.run(args);
	}
}
