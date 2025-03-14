package com.andyadc.marketing.domain.group.activity.service.trial.factory;

import com.andyadc.marketing.domain.group.activity.model.entity.MarketProductEntity;
import com.andyadc.marketing.domain.group.activity.model.entity.TrialBalanceEntity;
import com.andyadc.marketing.domain.group.activity.model.valobj.GroupBuyingActivityDiscountVO;
import com.andyadc.marketing.domain.group.activity.model.valobj.SkuVO;
import com.andyadc.marketing.domain.group.activity.service.trial.node.RootNode;
import com.andyadc.marketing.types.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 活动策略工厂
 */
@Service
public class DefaultActivityStrategyFactory {

	private final RootNode rootNode;

	public DefaultActivityStrategyFactory(RootNode rootNode) {
		this.rootNode = rootNode;
	}

	public StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity> strategyHandler() {
		return rootNode;
	}

	public static class DynamicContext {
		// 拼团活动营销配置值对象
		private GroupBuyingActivityDiscountVO groupBuyingActivityDiscountVO;
		// 商品信息
		private SkuVO skuVO;
		// 折扣金额
		private BigDecimal deductionPrice;
		// 支付金额
		private BigDecimal payPrice;
		// 活动可见性限制
		private boolean visible;
		// 活动
		private boolean enable;

		public GroupBuyingActivityDiscountVO getGroupBuyingActivityDiscountVO() {
			return groupBuyingActivityDiscountVO;
		}

		public void setGroupBuyingActivityDiscountVO(GroupBuyingActivityDiscountVO groupBuyingActivityDiscountVO) {
			this.groupBuyingActivityDiscountVO = groupBuyingActivityDiscountVO;
		}

		public SkuVO getSkuVO() {
			return skuVO;
		}

		public void setSkuVO(SkuVO skuVO) {
			this.skuVO = skuVO;
		}

		public BigDecimal getDeductionPrice() {
			return deductionPrice;
		}

		public void setDeductionPrice(BigDecimal deductionPrice) {
			this.deductionPrice = deductionPrice;
		}

		public BigDecimal getPayPrice() {
			return payPrice;
		}

		public void setPayPrice(BigDecimal payPrice) {
			this.payPrice = payPrice;
		}

		public boolean isVisible() {
			return visible;
		}

		public void setVisible(boolean visible) {
			this.visible = visible;
		}

		public boolean isEnable() {
			return enable;
		}

		public void setEnable(boolean enable) {
			this.enable = enable;
		}
	}

}
