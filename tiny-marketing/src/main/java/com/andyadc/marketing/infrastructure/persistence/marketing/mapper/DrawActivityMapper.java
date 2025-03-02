package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawActivityMapper {

	int deleteByPrimaryKey(Long id);

	int insert(DrawActivity row);

	int insertSelective(DrawActivity row);

	DrawActivity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivity row);

	int updateByPrimaryKey(DrawActivity row);
}
