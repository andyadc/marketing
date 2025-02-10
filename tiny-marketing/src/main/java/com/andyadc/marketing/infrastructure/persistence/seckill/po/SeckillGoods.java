package com.andyadc.marketing.infrastructure.persistence.seckill.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SeckillGoods implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 商品id
	 */
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(BigDecimal activityPrice) {
		this.activityPrice = activityPrice;
	}

	public Integer getInitialStock() {
		return initialStock;
	}

	public void setInitialStock(Integer initialStock) {
		this.initialStock = initialStock;
	}

	public Integer getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl == null ? null : imgUrl.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
}
