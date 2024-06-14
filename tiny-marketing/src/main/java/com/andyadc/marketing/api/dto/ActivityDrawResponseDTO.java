package com.andyadc.marketing.api.dto;

/**
 * 活动抽奖返回对象
 */
public class ActivityDrawResponseDTO {

	/**
	 * 奖品ID
	 */
	private Integer awardId;

	/**
	 * 奖品标题
	 */
	private String awardTitle;

	/**
	 * 排序编号【策略奖品配置的奖品顺序编号】
	 */
	private Integer awardIndex;

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

	public Integer getAwardIndex() {
		return awardIndex;
	}

	public void setAwardIndex(Integer awardIndex) {
		this.awardIndex = awardIndex;
	}

	@Override
	public String toString() {
		return "ActivityDrawResponseDTO{" +
			"awardId=" + awardId +
			", awardTitle=" + awardTitle +
			", awardIndex=" + awardIndex +
			'}';
	}
}
