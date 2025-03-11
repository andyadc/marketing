package com.andyadc.marketing.domain.group.activity.service.trial;

import com.andyadc.marketing.domain.group.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.andyadc.marketing.types.tree.AbstractAsyncStrategyRouter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 抽象的拼团营销支撑类
 */
public abstract class AbstractGroupBuyingSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractAsyncStrategyRouter<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

	@Override
	protected void async(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {

	}

}
