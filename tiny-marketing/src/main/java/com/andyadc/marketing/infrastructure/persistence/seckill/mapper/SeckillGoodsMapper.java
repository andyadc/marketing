package com.andyadc.marketing.infrastructure.persistence.seckill.mapper;

import com.andyadc.marketing.infrastructure.persistence.seckill.po.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillGoodsMapper {

	int deleteByPrimaryKey(Long id);

	int insert(SeckillGoods row);

	int insertSelective(SeckillGoods row);

	SeckillGoods selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SeckillGoods row);

	int updateByPrimaryKey(SeckillGoods row);
}
