package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivitySku;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawActivitySkuMapper {

	int deleteByPrimaryKey(Long id);

	int insert(DrawActivitySku row);

	int insertSelective(DrawActivitySku row);

	DrawActivitySku selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivitySku row);

	int updateByPrimaryKey(DrawActivitySku row);
}
