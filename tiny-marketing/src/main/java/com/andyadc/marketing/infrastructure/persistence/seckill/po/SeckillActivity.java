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
public class SeckillActivity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 秒杀活动id
	 */
	@Id
	private Long id;
	/**
	 * 活动名称
	 */
	private String activityName;
	/**
	 * 状态：0：已发布； 1：上线； 2：下线
	 */
	private Integer status;
	/**
	 * 开始时间
	 */
	private LocalDateTime startTime;
	/**
	 * 结束时间
	 */
	private LocalDateTime endTime;
	/**
	 * 活动秒杀
	 */
	private String activityDesc;
}
