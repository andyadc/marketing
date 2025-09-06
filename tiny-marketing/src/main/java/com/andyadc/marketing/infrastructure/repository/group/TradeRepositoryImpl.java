package com.andyadc.marketing.infrastructure.repository.group;

import com.andyadc.marketing.domain.group.trade.repository.TradeRepository;

public class TradeRepositoryImpl implements TradeRepository {

	@Override
	public boolean occupyTeamStock(String teamStockKey, String recoveryTeamStockKey, Integer target, Integer validTime) {

		return false;
	}

}
