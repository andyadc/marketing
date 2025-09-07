package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Award implements Serializable {

	@Serial
	private static final long serialVersionUID = -795765066427670323L;

	// 自增主键
	@Id
	private Long id;
	/**
	 * 抽奖奖品ID - 内部流转使用
	 */
	private Integer awardId;
	/**
	 * 奖品对接标识 - 每一个都是一个对应的发奖策略
	 */
	private String awardKey;
	/**
	 * 奖品配置信息
	 */
	private String awardConfig;
	/**
	 * 奖品内容描述
	 */
	private String awardDesc;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	@PrePersist
	public void prePersist() {
		this.createTime = LocalDateTime.now();
		this.updateTime = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.updateTime = LocalDateTime.now();
	}

}
