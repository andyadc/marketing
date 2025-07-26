package com.andyadc.marketing.domain.group.activity.service.trial.node;

import com.andyadc.codecraft.base.util.JsonUtils;
import com.andyadc.marketing.domain.group.activity.model.entity.MarketProductEntity;
import com.andyadc.marketing.domain.group.activity.model.entity.TrialCalculationEntity;
import com.andyadc.marketing.domain.group.activity.service.trial.AbstractGroupBuyingSupport;
import com.andyadc.marketing.domain.group.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.andyadc.marketing.types.exception.GroupBuyingException;
import com.andyadc.marketing.types.tree.StrategyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常节点处理；无营销、流程降级、超时调用等，都可以路由到 ErrorNode 节点统一处理
 */
public class ErrorNode extends AbstractGroupBuyingSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialCalculationEntity> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected TrialCalculationEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
		logger.info("拼团商品查询试算服务 - NoMarketNode userId: {} requestParameter: {}", requestParameter.getUserId(), JsonUtils.toJson(requestParameter));

		// 无营销配置
		if (null == dynamicContext.getGroupBuyingActivityDiscountVO() || null == dynamicContext.getSkuVO()) {
			logger.warn("商品无拼团营销配置 {}", requestParameter.getGoodsId());
			throw new GroupBuyingException();
		}

		return null;
	}

	@Override
	public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialCalculationEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
		return defaultStrategyHandler;
	}

}
