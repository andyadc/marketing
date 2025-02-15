package com.andyadc.marketing.domain.activity.event;

import com.andyadc.codecraft.base.messaging.event.BaseEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 活动sku库存清空消息
 */
@Component
public class ActivitySkuStockZeroMessageEvent extends BaseEvent<Long> {

	private String topic;

	@Override
	public EventMessage<Long> buildEventMessage(Long sku) {
		return EventMessage.<Long>builder()
			.id(UUID.randomUUID().toString())
			.timestamp(LocalDateTime.now())
			.data(sku)
			.build();
	}

	@Override
	public String topic() {
		return topic;
	}
}
