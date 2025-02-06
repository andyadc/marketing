package com.andyadc.marketing.api.dto;

import java.io.Serializable;

/**
 * 活动抽奖请求对象
 */
public class ActivityDrawRequestDTO implements Serializable {

	private static final long serialVersionUID = -8889741320371882936L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 活动ID
	 */
	private Long activityId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	@Override
	public String toString() {
		return "ActivityDrawRequestDTO{" +
			"userId=" + userId +
			", activityId=" + activityId +
			'}';
	}
}
