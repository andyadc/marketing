package com.andyadc.marketing.infrastructure.persistence.group.po;

import java.time.LocalDateTime;

public class GroupBuyingActivity {
	/**
	 * 自增
	 */
	private Long id;

	/**
	 * 活动ID
	 */
	private Long activityId;

	/**
	 * 活动名称
	 */
	private String activityName;

	/**
	 * 折扣ID
	 */
	private String discountId;

	/**
	 * 拼团方式（0自动成团、1达成目标拼团）
	 */
	private Byte groupType;

	/**
	 * 拼团次数限制
	 */
	private Integer takeLimitCount;

	/**
	 * 拼团目标
	 */
	private Integer target;

	/**
	 * 拼团时长（分钟）
	 */
	private Integer validTime;

	/**
	 * 活动状态（0创建、1生效、2过期、3废弃）
	 */
	private Byte status;

	/**
	 * 活动开始时间
	 */
	private LocalDateTime startTime;

	/**
	 * 活动结束时间
	 */
	private LocalDateTime endTime;

	/**
	 * 人群标签规则标识
	 */
	private String tagId;

	/**
	 * 人群标签规则范围（多选；1可见限制、2参与限制）
	 */
	private String tagScope;

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

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId == null ? null : discountId.trim();
	}

	public Byte getGroupType() {
		return groupType;
	}

	public void setGroupType(Byte groupType) {
		this.groupType = groupType;
	}

	public Integer getTakeLimitCount() {
		return takeLimitCount;
	}

	public void setTakeLimitCount(Integer takeLimitCount) {
		this.takeLimitCount = takeLimitCount;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public Integer getValidTime() {
		return validTime;
	}

	public void setValidTime(Integer validTime) {
		this.validTime = validTime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId == null ? null : tagId.trim();
	}

	public String getTagScope() {
		return tagScope;
	}

	public void setTagScope(String tagScope) {
		this.tagScope = tagScope == null ? null : tagScope.trim();
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
