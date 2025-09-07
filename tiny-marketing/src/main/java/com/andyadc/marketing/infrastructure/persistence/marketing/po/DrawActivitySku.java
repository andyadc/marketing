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
public class DrawActivitySku implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 自增ID
	 */
	@Id
	private Long id;
	/**
	 * 商品sku - 把每一个组合当做一个商品
	 */
    private Integer sku;
    /**
     * 活动ID
     */
    private Integer activityId;
    /**
     * 活动个人参与次数ID
     */
    private Integer activityCountId;
    /**
     * 商品库存
     */
    private Integer stockCount;
    /**
     * 剩余库存
     */
    private Integer stockCountSurplus;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
