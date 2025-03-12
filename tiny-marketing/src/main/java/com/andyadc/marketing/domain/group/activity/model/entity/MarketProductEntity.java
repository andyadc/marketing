package com.andyadc.marketing.domain.group.activity.model.entity;

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

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}
