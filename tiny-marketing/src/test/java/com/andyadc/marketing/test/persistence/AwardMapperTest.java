package com.andyadc.marketing.test.persistence;

import com.andyadc.codecraft.base.util.JsonUtils;
import com.andyadc.marketing.infrastructure.persistence.award.mapper.AwardMapper;
import com.andyadc.marketing.infrastructure.persistence.award.po.Award;
import com.andyadc.marketing.test.TestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class AwardMapperTest extends TestBase {

	@Autowired
	AwardMapper awardMapper;

	@Test
	public void selectByAwardId() {
		Award award = awardMapper.selectByAwardId(101);
		System.out.println(JsonUtils.toJson(award));
	}

	@Transactional
	@Test
	@Rollback(true)
	public void insertSelective() {
		Award award = new Award();
		award.setAwardId(6);
		award.setAwardKey("Key-1");
		award.setAwardConfig("Config-1");
		award.setAwardDesc("Desc-1");
		award.setCreateTime(LocalDateTime.now());
		award.setUpdateTime(LocalDateTime.now());
		awardMapper.insertSelective(award);
		System.out.println(JsonUtils.toJson(award));

//		int i = 1 / 0;
	}

	@Test
	public void selectByPrimaryKey() {
		Award award = awardMapper.selectByPrimaryKey(1L);
		System.out.println(JsonUtils.toJson(award));
	}

}
