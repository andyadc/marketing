package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivityCount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawActivityCountMapper {

	int deleteByPrimaryKey(Long id);

	int insert(DrawActivityCount row);

	int insertSelective(DrawActivityCount row);

	DrawActivityCount selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivityCount row);

	int updateByPrimaryKey(DrawActivityCount row);
}
