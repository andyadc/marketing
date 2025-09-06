package com.andyadc.marketing.domain.group.trade.repository;

public interface TradeRepository {

	/**
	 * 占用库存
	 * @param teamStockKey
	 * @param recoveryTeamStockKey
	 * @param target
	 * @param validTime
	 * @return
	 */
	boolean occupyTeamStock(String teamStockKey, String recoveryTeamStockKey, Integer target, Integer validTime);

}
