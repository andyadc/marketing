package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivityOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawActivityOrderMapper {

	int deleteByPrimaryKey(Long id);

	int insert(DrawActivityOrder row);

	int insertSelective(DrawActivityOrder row);

	DrawActivityOrder selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivityOrder row);

	int updateByPrimaryKey(DrawActivityOrder row);
}
