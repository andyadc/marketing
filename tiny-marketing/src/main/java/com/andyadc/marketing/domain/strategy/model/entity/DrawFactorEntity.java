package com.andyadc.marketing.domain.strategy.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 抽奖因子实体
 */
@Getter
@Setter
public class DrawFactorEntity {

	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 策略ID
	 */
	private Integer strategyId;
	/**
	 * 结束时间
	 */
	private LocalDateTime endDateTime;

	@Override
	public String toString() {
		return "DrawAwardEntity{" +
			"userId=" + userId +
			", strategyId=" + strategyId +
			", endDateTime=" + endDateTime +
			'}';
	}
}
