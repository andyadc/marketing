package com.andyadc.marketing.infrastructure.persistence.award.mapper;

import com.andyadc.marketing.infrastructure.persistence.award.po.Strategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StrategyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Strategy row);

    int insertSelective(Strategy row);

    Strategy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Strategy row);

    int updateByPrimaryKey(Strategy row);

    @Select(value = "SELECT * FROM strategy WHERE strategy_id = #{strategyId}")
    Strategy selectByStrategyId(Integer strategyId);
}
