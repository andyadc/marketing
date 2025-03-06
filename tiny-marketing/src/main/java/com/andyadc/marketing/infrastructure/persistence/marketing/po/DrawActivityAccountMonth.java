package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import java.time.LocalDateTime;

public class DrawActivityAccountMonth {
	/**
	 * 自增ID
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 活动ID
	 */
	private Integer activityId;

	/**
	 * 月（yyyy-mm）
	 */
	private String month;

	/**
	 * 月次数
	 */
	private Integer monthCount;

	/**
	 * 月次数-剩余
	 */
	private Integer monthCountSurplus;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month == null ? null : month.trim();
	}

	public Integer getMonthCount() {
		return monthCount;
	}

	public void setMonthCount(Integer monthCount) {
		this.monthCount = monthCount;
	}

	public Integer getMonthCountSurplus() {
		return monthCountSurplus;
	}

	public void setMonthCountSurplus(Integer monthCountSurplus) {
		this.monthCountSurplus = monthCountSurplus;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
}
