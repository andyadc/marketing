package com.andyadc.marketing.test.persistence;

import com.andyadc.marketing.infrastructure.persistence.entity.Award;
import com.andyadc.marketing.infrastructure.persistence.mapper.AwardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTests {

    @Autowired
    private AwardMapper awardMapper;

    @Test
    public void awardMapper_selectByAwardId() {
        Award award = awardMapper.selectByAwardId(1);
        System.out.println(award);
    }
}
