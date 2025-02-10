package com.andyadc.marketing.infrastructure.persistence.award.mapper;

import com.andyadc.marketing.infrastructure.persistence.award.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivitySkuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivitySku row);

    int insertSelective(RaffleActivitySku row);

    RaffleActivitySku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivitySku row);

    int updateByPrimaryKey(RaffleActivitySku row);
}
