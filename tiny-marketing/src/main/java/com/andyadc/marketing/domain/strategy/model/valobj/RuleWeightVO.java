package com.andyadc.marketing.domain.strategy.model.valobj;

import java.util.List;

/**
 * 权重规则值对象
 */
public class RuleWeightVO {

	// 原始规则值配置
	private String ruleValue;
	// 权重值
	private Integer weight;
	// 奖品配置
	private List<Integer> awardIds;
	// 奖品列表
	private List<Award> awardList;

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<Integer> getAwardIds() {
		return awardIds;
	}

	public void setAwardIds(List<Integer> awardIds) {
		this.awardIds = awardIds;
	}

	public List<Award> getAwardList() {
		return awardList;
	}

	public void setAwardList(List<Award> awardList) {
		this.awardList = awardList;
	}

	@Override
	public String toString() {
		return "RuleWeightVO{" +
			"ruleValue=" + ruleValue +
			", weight=" + weight +
			", awardIds=" + awardIds +
			", awardList=" + awardList +
			'}';
	}

	public static class Award {
		private Integer awardId;
		private String awardTitle;

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

		@Override
		public String toString() {
			return "Award{" +
				"awardId=" + awardId +
				", awardTitle=" + awardTitle +
				'}';
		}
	}
}
