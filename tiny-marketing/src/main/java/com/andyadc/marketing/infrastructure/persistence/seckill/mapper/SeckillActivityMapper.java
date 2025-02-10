package com.andyadc.marketing.infrastructure.persistence.seckill.mapper;

import com.andyadc.marketing.infrastructure.persistence.seckill.po.SeckillActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillActivityMapper {

	int deleteByPrimaryKey(Long id);

	int insert(SeckillActivity row);

	int insertSelective(SeckillActivity row);

	SeckillActivity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SeckillActivity row);

	int updateByPrimaryKey(SeckillActivity row);
}
