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
public class Strategy implements Serializable {

	@Serial
	private static final long serialVersionUID = -4760682799055091927L;

	/**
	 * 自增ID
	 */
	@Id
	private Long id;
	/**
	 * 抽奖策略ID
	 */
	private Integer strategyId;
	/**
	 * 抽奖策略描述
	 */
	private String strategyDesc;
	/**
	 * 抽奖规则模型
	 */
	private String ruleModels;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
}
