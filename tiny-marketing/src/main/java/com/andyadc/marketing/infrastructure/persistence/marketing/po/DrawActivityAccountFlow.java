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
public class DrawActivityAccountFlow implements Serializable {

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
     * 日次数
     */
    private Integer dayCount;
    /**
     * 月次数
     */
    private Integer monthCount;
    /**
     * 流水ID - 生成的唯一ID
     */
    private String flowId;
    /**
     * 流水渠道（activity-活动领取、sale-购买、redeem-兑换、free-免费赠送）
     */
    private String flowChannel;
    /**
     * 业务ID（外部透传，活动ID、订单ID）
     */
    private String bizId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
