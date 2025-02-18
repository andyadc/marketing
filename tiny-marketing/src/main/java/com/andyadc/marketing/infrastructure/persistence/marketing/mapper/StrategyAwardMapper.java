package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StrategyAwardMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(StrategyAward row);

    int insertSelective(StrategyAward row);

    StrategyAward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StrategyAward row);

    int updateByPrimaryKey(StrategyAward row);

    @Select(value = "SELECT * FROM strategy_award WHERE strategy_id = #{strategyId}")
    List<StrategyAward> queryByStrategyId(Integer strategyId);
}
