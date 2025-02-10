package com.andyadc.marketing.infrastructure.persistence.seckill.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SeckillReservationGoods implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 数据主键
	 */
	private Long id;
	/**
	 * 预约配置id
	 */
	private Long reserveConfigId;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 预约时间
	 */
	private LocalDateTime reserveTime;
	/**
	 * 状态，1：正常；0：删除
	 */
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReserveConfigId() {
		return reserveConfigId;
	}

	public void setReserveConfigId(Long reserveConfigId) {
		this.reserveConfigId = reserveConfigId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(LocalDateTime reserveTime) {
		this.reserveTime = reserveTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
