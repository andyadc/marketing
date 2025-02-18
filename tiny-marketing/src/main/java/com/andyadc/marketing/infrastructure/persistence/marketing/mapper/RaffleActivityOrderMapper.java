package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.RaffleActivityOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivityOrder row);

    int insertSelective(RaffleActivityOrder row);

    RaffleActivityOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivityOrder row);

    int updateByPrimaryKey(RaffleActivityOrder row);
}
