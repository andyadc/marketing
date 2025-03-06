package com.andyadc.marketing.domain.strategy.service.armory;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 策略装配库，负责初始化策略计算
 */
@Service
public class StrategyAssembleDispatch implements StrategyDispatch, StrategyAssemble {

	@Override
	public boolean assembleLotteryStrategy(Integer strategyId) {
		return false;
	}

	@Override
	public boolean assembleLotteryStrategyByActivityId(Integer activityId) {
		return false;
	}

	@Override
	public Integer getRandomAwardId(Integer strategyId) {
		return null;
	}

	@Override
	public Integer getRandomAwardId(Integer strategyId, String ruleWeightValue) {
		return null;
	}

	@Override
	public Integer getRandomAwardId(String key) {
		return null;
	}

	@Override
	public Boolean subtractionAwardStock(Integer strategyId, Integer awardId, LocalDateTime endDateTime) {
		return null;
	}
}
