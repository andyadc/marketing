package com.andyadc.marketing.infrastructure.persistence.award.mapper;

import com.andyadc.marketing.infrastructure.persistence.award.po.Award;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AwardMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Award row);

    int insertSelective(Award row);

    Award selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Award row);

    int updateByPrimaryKey(Award row);

    @Results(value = {
            @Result(property = "awardDesc", column = "award_desc")
    })
    @Select(value = "SELECT * FROM award WHERE award_id = #{awardId}")
    Award selectByAwardId(Integer awardId);
}
