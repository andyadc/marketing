package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class StrategyAward implements Serializable {

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
	 * 抽奖奖品ID - 内部流转使用
	 */
	private Integer awardId;
	/**
	 * 抽奖奖品标题
	 */
	private String awardTitle;
	/**
	 * 抽奖奖品副标题
	 */
	private String awardSubtitle;
	/**
	 * 奖品库存总量
	 */
	private Integer awardCount;
	/**
	 * 奖品库存剩余
	 */
	private Integer awardCountSurplus;
	/**
	 * 奖品中奖概率
	 */
	private BigDecimal awardRate;
	/**
	 * 规则模型，rule配置的模型同步到此表，便于使用
	 */
	private String ruleModels;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;
}
