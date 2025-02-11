package com.andyadc.marketing.infrastructure.repository;

import com.andyadc.marketing.domain.seckill.SeckillGoodsRepository;
import com.andyadc.marketing.infrastructure.persistence.seckill.mapper.SeckillGoodsMapper;
import com.andyadc.marketing.infrastructure.persistence.seckill.po.SeckillGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SeckillGoodsRepositoryImpl implements SeckillGoodsRepository {

	private SeckillGoodsMapper goodsMapper;

	public void saveSeckillGoods() {
		SeckillGoods goods = new SeckillGoods();
		goodsMapper.insertSelective(goods);
	}

	@Autowired
	public void setGoodsMapper(SeckillGoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}

}
