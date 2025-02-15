package com.andyadc.marketing.domain.strategy.service.armory;

import java.time.LocalDateTime;

/**
 * 策略抽奖调度
 */
public interface StrategyDispatch {

	/**
	 * 获取抽奖策略装配的随机结果
	 *
	 * @param strategyId 策略ID
	 * @return 抽奖结果
	 */
	Integer getRandomAwardId(Integer strategyId);

	/**
	 * 获取抽奖策略装配的随机结果
	 *
	 * @param strategyId 权重ID
	 * @return 抽奖结果
	 */
	Integer getRandomAwardId(Integer strategyId, String ruleWeightValue);

	/**
	 * 获取抽奖策略装配的随机结果
	 *
	 * @param key = strategyId + _ + ruleWeightValue；
	 * @return 抽奖结果
	 */
	Integer getRandomAwardId(String key);

	/**
	 * 根据策略ID和奖品ID，扣减奖品缓存库存
	 *
	 * @param strategyId  策略ID
	 * @param awardId     奖品ID
	 * @param endDateTime 活动结束时间
	 * @return 扣减结果
	 */
	Boolean subtractionAwardStock(Integer strategyId, Integer awardId, LocalDateTime endDateTime);
}
