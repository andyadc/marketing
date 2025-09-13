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
public class StrategyRule implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

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
	 * 抽奖奖品ID【规则类型为策略，则不需要奖品ID】
	 */
	private Integer awardId;
	/**
	 * 抽象规则类型；1-策略规则、2-奖品规则
	 */
	private Boolean ruleType;
	/**
	 * 抽奖规则类型【rule_random - 随机值计算、rule_lock - 抽奖几次后解锁、rule_luck_award - 幸运奖(兜底奖品)】
	 */
	private String ruleModel;
	/**
	 * 抽奖规则比值
	 */
	private String ruleValue;
	/**
	 * 抽奖规则描述
	 */
	private String ruleDesc;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
}
