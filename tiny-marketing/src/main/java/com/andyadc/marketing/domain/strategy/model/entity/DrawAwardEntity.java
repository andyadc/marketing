package com.andyadc.marketing.domain.strategy.model.entity;

/**
 * 抽奖奖品实体
 */
public class DrawAwardEntity {

	/**
	 * 奖品ID
	 */
	private Integer awardId;
	/**
	 * 抽奖奖品标题
	 */
	private String awardTitle;
	/**
	 * 奖品配置信息
	 */
	private String awardConfig;
	/**
	 * 奖品顺序号
	 */
	private Integer sort;

	public Integer getAwardId() {
		return awardId;
	}

	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

	public String getAwardTitle() {
		return awardTitle;
	}

	public void setAwardTitle(String awardTitle) {
		this.awardTitle = awardTitle;
	}

	public String getAwardConfig() {
		return awardConfig;
	}

	public void setAwardConfig(String awardConfig) {
		this.awardConfig = awardConfig;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "DrawAwardEntity{" +
			"awardId=" + awardId +
			", awardTitle=" + awardTitle +
			", awardConfig=" + awardConfig +
			", sort=" + sort +
			'}';
	}
}
