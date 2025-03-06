package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivityAccountDay;

public interface DrawActivityAccountDayMapper {
	int deleteByPrimaryKey(Long id);

	int insert(DrawActivityAccountDay row);

	int insertSelective(DrawActivityAccountDay row);

	DrawActivityAccountDay selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivityAccountDay row);

	int updateByPrimaryKey(DrawActivityAccountDay row);
}
