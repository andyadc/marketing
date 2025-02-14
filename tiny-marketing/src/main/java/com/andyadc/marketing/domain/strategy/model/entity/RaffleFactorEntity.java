package com.andyadc.marketing.domain.strategy.model.entity;

import java.time.LocalDateTime;

/**
 * 抽奖因子实体
 */
public class RaffleFactorEntity {

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Override
	public String toString() {
		return "RaffleFactorEntity{" +
			"userId=" + userId +
			", strategyId=" + strategyId +
			", endDateTime=" + endDateTime +
			'}';
	}
}
