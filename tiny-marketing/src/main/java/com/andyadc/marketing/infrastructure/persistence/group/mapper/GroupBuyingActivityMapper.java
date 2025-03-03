package com.andyadc.marketing.infrastructure.persistence.group.mapper;

import com.andyadc.marketing.infrastructure.persistence.group.po.GroupBuyingActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupBuyingActivityMapper {
	int deleteByPrimaryKey(Long id);

	int insert(GroupBuyingActivity row);

	int insertSelective(GroupBuyingActivity row);

	GroupBuyingActivity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(GroupBuyingActivity row);

	int updateByPrimaryKey(GroupBuyingActivity row);
}
