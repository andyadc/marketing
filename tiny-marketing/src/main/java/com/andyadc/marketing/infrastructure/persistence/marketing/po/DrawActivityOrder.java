package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class DrawActivityOrder implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 自增ID
	 */
	@Id
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
     * 活动名称
     */
    private String activityName;
    /**
     * 抽奖策略ID
     */
    private Integer strategyId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 下单时间
     */
    private LocalDateTime orderTime;
    /**
     * 订单状态（not_used、used、expire）
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
}
