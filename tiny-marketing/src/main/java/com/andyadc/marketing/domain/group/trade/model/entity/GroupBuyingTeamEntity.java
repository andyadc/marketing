package com.andyadc.marketing.domain.group.trade.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 拼团组队实体对象
 */
@Getter
@Setter
public class GroupBuyingTeamEntity {

	/**
	 * 拼单组队ID
	 */
	private String teamId;
	/**
	 * 活动ID
	 */
	private Integer activityId;
}
