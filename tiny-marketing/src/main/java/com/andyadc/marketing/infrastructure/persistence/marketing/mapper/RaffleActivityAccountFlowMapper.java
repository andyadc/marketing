package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.RaffleActivityAccountFlow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityAccountFlowMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivityAccountFlow row);

    int insertSelective(RaffleActivityAccountFlow row);

    RaffleActivityAccountFlow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivityAccountFlow row);

    int updateByPrimaryKey(RaffleActivityAccountFlow row);
}
