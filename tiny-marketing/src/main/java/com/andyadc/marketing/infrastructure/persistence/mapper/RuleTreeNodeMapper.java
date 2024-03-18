package com.andyadc.marketing.infrastructure.persistence.mapper;

import com.andyadc.marketing.infrastructure.persistence.entity.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RuleTreeNodeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RuleTreeNode row);

    int insertSelective(RuleTreeNode row);

    RuleTreeNode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RuleTreeNode row);

    int updateByPrimaryKey(RuleTreeNode row);
}