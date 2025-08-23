package com.andyadc.marketing.domain.strategy.model.valobj;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 权重规则值对象
 */
@Getter
@Setter
public class RuleWeightVO {

	// 原始规则值配置
	private String ruleValue;
	// 权重值
	private Integer weight;
	// 奖品配置
	private List<Integer> awardIds;
	// 奖品列表
	private List<Award> awardList;

	@Override
	public String toString() {
		return "RuleWeightVO{" +
			"ruleValue=" + ruleValue +
			", weight=" + weight +
			", awardIds=" + awardIds +
			", awardList=" + awardList +
			'}';
	}

	@Getter
	@Setter
	public static class Award {
		private Integer awardId;
		private String awardTitle;

		@Override
		public String toString() {
			return "Award{" +
				"awardId=" + awardId +
				", awardTitle=" + awardTitle +
				'}';
		}
	}
}
