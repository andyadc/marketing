package com.andyadc.marketing.domain.strategy.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 抽奖奖品实体
 */
@Getter
@Setter
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
