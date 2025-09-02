package com.andyadc.marketing.infrastructure.persistence.seckill.po;

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
public class SeckillReservationGoods implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	/**
	 * 数据主键
	 */
	@Id
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
}
