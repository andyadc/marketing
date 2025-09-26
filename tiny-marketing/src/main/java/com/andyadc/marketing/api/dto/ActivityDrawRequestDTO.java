package com.andyadc.marketing.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 活动抽奖请求对象
 */
@Getter
@Setter
public class ActivityDrawRequestDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = -8889741320371882936L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 活动ID
	 */
	private Long activityId;

	@Override
	public String toString() {
		return "ActivityDrawRequestDTO{" +
			"userId=" + userId +
			", activityId=" + activityId +
			'}';
	}
}
