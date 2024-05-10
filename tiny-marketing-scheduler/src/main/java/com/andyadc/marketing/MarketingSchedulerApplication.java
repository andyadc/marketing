package com.andyadc.marketing;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MarketingSchedulerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MarketingSchedulerApplication.class)
//			.web(WebApplicationType.NONE)
			.run(args);
	}
}
