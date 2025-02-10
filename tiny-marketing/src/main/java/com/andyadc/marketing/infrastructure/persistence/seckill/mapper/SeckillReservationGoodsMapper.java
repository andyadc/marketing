package com.andyadc.marketing.infrastructure.persistence.seckill.mapper;

import com.andyadc.marketing.infrastructure.persistence.seckill.po.SeckillReservationGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillReservationGoodsMapper {

	int deleteByPrimaryKey(Long id);

	int insert(SeckillReservationGoods row);

	int insertSelective(SeckillReservationGoods row);

	SeckillReservationGoods selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SeckillReservationGoods row);

	int updateByPrimaryKey(SeckillReservationGoods row);
}
