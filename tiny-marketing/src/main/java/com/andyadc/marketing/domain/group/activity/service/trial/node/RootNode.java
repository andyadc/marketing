package com.andyadc.marketing.domain.group.activity.service.trial.node;

import com.andyadc.marketing.domain.group.activity.model.entity.MarketProductEntity;
import com.andyadc.marketing.domain.group.activity.model.entity.TrialCalculationEntity;
import com.andyadc.marketing.domain.group.activity.service.trial.AbstractGroupBuyingSupport;
import com.andyadc.marketing.domain.group.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.andyadc.marketing.types.tree.StrategyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 根节点
 */
@Service
public class RootNode extends AbstractGroupBuyingSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialCalculationEntity> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected TrialCalculationEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
		return null;
	}

	@Override
	public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialCalculationEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
		return null;
	}

}
