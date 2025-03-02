package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivityAccountFlow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawActivityAccountFlowMapper {

	int deleteByPrimaryKey(Long id);

	int insert(DrawActivityAccountFlow row);

	int insertSelective(DrawActivityAccountFlow row);

	DrawActivityAccountFlow selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivityAccountFlow row);

	int updateByPrimaryKey(DrawActivityAccountFlow row);
}
