package com.andyadc.marketing.test.persistence.group;

import com.andyadc.codecraft.base.util.JsonUtils;
import com.andyadc.marketing.infrastructure.persistence.group.mapper.GroupBuyingActivityMapper;
import com.andyadc.marketing.infrastructure.persistence.group.po.GroupBuyingActivity;
import com.andyadc.marketing.test.TestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class GroupBuyingActivityMapperTest extends TestBase {

	@Autowired
	private GroupBuyingActivityMapper groupBuyingActivityMapper;

	@Test
	public void selectByPrimaryKey() {
		GroupBuyingActivity groupBuyingActivity = groupBuyingActivityMapper.selectByPrimaryKey(1L);
		System.out.println(JsonUtils.toJson(groupBuyingActivity));
	}

}
