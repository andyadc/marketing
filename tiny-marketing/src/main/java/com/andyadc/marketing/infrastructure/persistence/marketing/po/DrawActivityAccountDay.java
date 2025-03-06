package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import java.time.LocalDateTime;

public class DrawActivityAccountDay {
	/**
	 * 自增ID
	 */
	private Long id;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 活动ID
	 */
	private Integer activityId;

	/**
	 * 日期（yyyy-mm-dd）
	 */
	private String day;

	/**
	 * 日次数
	 */
	private Integer dayCount;

	/**
	 * 日次数-剩余
	 */
	private Integer dayCountSurplus;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day == null ? null : day.trim();
	}

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	public Integer getDayCountSurplus() {
		return dayCountSurplus;
	}

	public void setDayCountSurplus(Integer dayCountSurplus) {
		this.dayCountSurplus = dayCountSurplus;
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
