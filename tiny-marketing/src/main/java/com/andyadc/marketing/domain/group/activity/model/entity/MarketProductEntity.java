package com.andyadc.marketing.domain.group.activity.model.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 营销商品实体信息
 */
@Data
@Builder
public class MarketProductEntity {

	/**
	 * 活动ID
	 */
	private Integer activityId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 商品ID
	 */
	private String goodsId;
	/**
	 * 渠道
	 */
	private String source;
	/**
	 * 来源
	 */
	private String channel;

}
