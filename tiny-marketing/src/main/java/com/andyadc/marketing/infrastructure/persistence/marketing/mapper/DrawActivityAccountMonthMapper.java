package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivityAccountMonth;

public interface DrawActivityAccountMonthMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(DrawActivityAccountMonth row);

	int insertSelective(DrawActivityAccountMonth row);

	DrawActivityAccountMonth selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DrawActivityAccountMonth row);

	int updateByPrimaryKey(DrawActivityAccountMonth row);
}
