package com.andyadc.marketing.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 活动抽奖返回对象
 */
@Getter
@Setter
public class ActivityDrawResponseDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = -7424960370842484038L;

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

	@Override
	public String toString() {
		return "ActivityDrawResponseDTO{" +
			"awardId=" + awardId +
			", awardTitle=" + awardTitle +
			", awardIndex=" + awardIndex +
			'}';
	}
}
