package com.andyadc.marketing.infrastructure.persistence.mapper;

import com.andyadc.marketing.infrastructure.persistence.entity.RaffleActivityCount;
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