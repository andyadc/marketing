package com.andyadc.marketing.infrastructure.persistence.award.mapper;

import com.andyadc.marketing.infrastructure.persistence.award.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityCountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivityCount row);

    int insertSelective(RaffleActivityCount row);

    RaffleActivityCount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivityCount row);

    int updateByPrimaryKey(RaffleActivityCount row);
}
