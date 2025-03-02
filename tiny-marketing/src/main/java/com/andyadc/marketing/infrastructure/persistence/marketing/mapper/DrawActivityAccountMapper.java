package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivityAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawActivityAccountMapper {

	int deleteByPrimaryKey(Long id);

	int insert(DrawActivityAccount row);

	int insertSelective(DrawActivityAccount row);

	DrawActivityAccount selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivityAccount row);

	int updateByPrimaryKey(DrawActivityAccount row);
}
