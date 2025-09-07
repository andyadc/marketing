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
public class DrawActivityAccountMonth implements Serializable {

	@Serial
	private static final long serialVersionUID = 8700496874289629547L;

	/**
	 * 自增ID
	 */
	@Id
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
}
