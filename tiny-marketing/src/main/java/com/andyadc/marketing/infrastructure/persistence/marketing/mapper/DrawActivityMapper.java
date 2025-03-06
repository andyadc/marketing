package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.DrawActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DrawActivityMapper {

	int deleteByPrimaryKey(Long id);

	int insert(DrawActivity row);

	int insertSelective(DrawActivity row);

	DrawActivity selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DrawActivity row);

	int updateByPrimaryKey(DrawActivity row);

	@Select(value = "SELECT * FROM draw_activity WHERE activity_id = #{activityId}")
	DrawActivity selectByActivityId(Integer activityId);

	@Select(value = "SELECT * FROM draw_activity WHERE strategy_id = #{strategyId}")
	DrawActivity selectByStrategyId(Integer strategyId);

}
