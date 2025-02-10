package com.andyadc.marketing.infrastructure.persistence.seckill.mapper;

import com.andyadc.marketing.infrastructure.persistence.seckill.po.SeckillUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillUserMapper {

	int deleteByPrimaryKey(Long id);

	int insert(SeckillUser row);

	int insertSelective(SeckillUser row);

	SeckillUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SeckillUser row);

	int updateByPrimaryKey(SeckillUser row);
}
