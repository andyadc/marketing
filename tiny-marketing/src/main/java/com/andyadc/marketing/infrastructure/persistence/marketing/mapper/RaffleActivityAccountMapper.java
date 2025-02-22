package com.andyadc.marketing.infrastructure.persistence.marketing.mapper;

import com.andyadc.marketing.infrastructure.persistence.marketing.po.RaffleActivityAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RaffleActivityAccountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RaffleActivityAccount row);

    int insertSelective(RaffleActivityAccount row);

    RaffleActivityAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RaffleActivityAccount row);

    int updateByPrimaryKey(RaffleActivityAccount row);
}
