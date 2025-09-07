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
public class DrawActivityAccountDay implements Serializable {

	@Serial
	private static final long serialVersionUID = -5179036857509235731L;

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
}
