package com.andyadc.marketing.infrastructure.persistence.seckill.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SeckillActivity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 秒杀活动id
	 */
	private Long id;
	/**
	 * 活动名称
	 */
	private String activityName;
	/**
	 * 状态：0：已发布； 1：上线； 2：下线
	 */
	private Integer status;
	/**
	 * 开始时间
	 */
	private LocalDateTime startTime;
	/**
	 * 结束时间
	 */
	private LocalDateTime endTime;
	/**
	 * 活动秒杀
	 */
	private String activityDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc == null ? null : activityDesc.trim();
	}
}
