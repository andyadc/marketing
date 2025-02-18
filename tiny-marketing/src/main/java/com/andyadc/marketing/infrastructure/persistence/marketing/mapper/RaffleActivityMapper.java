package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivity row);

    int insertSelective(RaffleActivity row);

    RaffleActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivity row);

    int updateByPrimaryKey(RaffleActivity row);
}
