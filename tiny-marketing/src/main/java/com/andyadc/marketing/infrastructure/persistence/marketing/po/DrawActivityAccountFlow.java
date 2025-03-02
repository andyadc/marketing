package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class DrawActivityAccountFlow implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 总次数
     */
    private Integer totalCount;
    /**
     * 日次数
     */
    private Integer dayCount;
    /**
     * 月次数
     */
    private Integer monthCount;
    /**
     * 流水ID - 生成的唯一ID
     */
    private String flowId;
    /**
     * 流水渠道（activity-活动领取、sale-购买、redeem-兑换、free-免费赠送）
     */
    private String flowChannel;
    /**
     * 业务ID（外部透传，活动ID、订单ID）
     */
    private String bizId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @Id
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    public String getFlowChannel() {
        return flowChannel;
    }

    public void setFlowChannel(String flowChannel) {
        this.flowChannel = flowChannel == null ? null : flowChannel.trim();
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
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
