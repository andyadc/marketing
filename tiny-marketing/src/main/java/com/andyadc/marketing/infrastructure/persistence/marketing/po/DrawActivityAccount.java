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
public class DrawActivityAccount implements Serializable {

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
     * 总次数
     */
    private Integer totalCount;
    /**
     * 总次数-剩余
     */
    private Integer totalCountSurplus;
    /**
     * 日次数
     */
    private Integer dayCount;
    /**
     * 日次数-剩余
     */
    private Integer dayCountSurplus;
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
