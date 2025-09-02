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
public class SeckillUser implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 状态，1：正常；2：冻结
	 */
	private Integer status;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
