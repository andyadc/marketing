package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Award implements Serializable {

	private static final long serialVersionUID = -795765066427670323L;

	// 自增主键
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

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAwardId() {
		return awardId;
	}

	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

	public String getAwardKey() {
		return awardKey;
	}

	public void setAwardKey(String awardKey) {
		this.awardKey = awardKey;
	}

	public String getAwardConfig() {
		return awardConfig;
	}

	public void setAwardConfig(String awardConfig) {
		this.awardConfig = awardConfig;
	}

	public String getAwardDesc() {
		return awardDesc;
	}

	public void setAwardDesc(String awardDesc) {
		this.awardDesc = awardDesc;
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
