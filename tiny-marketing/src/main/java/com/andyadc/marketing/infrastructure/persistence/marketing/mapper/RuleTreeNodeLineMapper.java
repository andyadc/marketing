package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RuleTreeNodeLineMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RuleTreeNodeLine row);

    int insertSelective(RuleTreeNodeLine row);

    RuleTreeNodeLine selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RuleTreeNodeLine row);

    int updateByPrimaryKey(RuleTreeNodeLine row);
}
