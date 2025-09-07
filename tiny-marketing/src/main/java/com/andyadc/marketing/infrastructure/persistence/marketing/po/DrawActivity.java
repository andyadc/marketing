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
public class DrawActivity implements Serializable {

	@Serial
	private static final long serialVersionUID = 6182377590561149408L;

	/**
	 * 自增ID
	 */
	@Id
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
}
