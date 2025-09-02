package com.andyadc.marketing.infrastructure.persistence.seckill.po;

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
public class SeckillGoods implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	/**
	 * 商品id
	 */
	@Id
	private Long id;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 活动id
	 */
	private Long activityId;
	/**
	 * 开始时间
	 */
	private LocalDateTime startTime;
	/**
	 * 结束时间
	 */
	private LocalDateTime endTime;
	/**
	 * 商品原价格
	 */
	private BigDecimal originalPrice;
	/**
	 * 商品秒杀价格
	 */
	private BigDecimal activityPrice;
	/**
	 * 商品初始库存
	 */
	private Integer initialStock;
	/**
	 * 商品当前可用库存
	 */
	private Integer availableStock;
	/**
	 * 商品描述
	 */
	private String description;
	/**
	 * 商品图片
	 */
	private String imgUrl;
	/**
	 * 状态，0：已发布； 1：上线； 2：下线
	 */
	private Integer status;
	/**
	 * 限购个数
	 */
	private Integer limitNum;
}
