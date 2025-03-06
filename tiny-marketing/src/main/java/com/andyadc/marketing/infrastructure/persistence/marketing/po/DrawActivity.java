package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import java.time.LocalDateTime;

public class DrawActivity {
	/**
	 * 自增ID
	 */
	private Long id;

	/**
	 * 活动ID
	 */
	private Integer activityId;

	/**
	 * 活动名称
	 */
	private String activityName;

	/**
	 * 活动描述
	 */
	private String activityDesc;

	/**
	 * 开始时间
	 */
	private LocalDateTime beginDatetime;

	/**
	 * 结束时间
	 */
	private LocalDateTime endDatetime;

	/**
	 * 抽奖策略ID
	 */
	private Integer strategyId;

	/**
	 * 活动状态
	 */
	private String state;

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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc == null ? null : activityDesc.trim();
	}

	public LocalDateTime getBeginDatetime() {
		return beginDatetime;
	}

	public void setBeginDatetime(LocalDateTime beginDatetime) {
		this.beginDatetime = beginDatetime;
	}

	public LocalDateTime getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(LocalDateTime endDatetime) {
		this.endDatetime = endDatetime;
	}

	public Integer getStrategyId() {
		return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
