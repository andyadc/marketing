package com.andyadc.marketing.infrastructure.persistence.award.mapper;

import com.andyadc.marketing.infrastructure.persistence.award.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StrategyRuleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StrategyRule row);

    int insertSelective(StrategyRule row);

    StrategyRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StrategyRule row);

    int updateByPrimaryKey(StrategyRule row);
}
