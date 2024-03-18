package com.andyadc.marketing.infrastructure.persistence.mapper;

import com.andyadc.marketing.infrastructure.persistence.entity.RuleTree;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RuleTreeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RuleTree row);

    int insertSelective(RuleTree row);

    RuleTree selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RuleTree row);

    int updateByPrimaryKey(RuleTree row);
}