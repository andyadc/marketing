package com.andyadc.marketing.test.persistence.seckill;

import com.andyadc.codecraft.base.util.JsonUtils;
import com.andyadc.marketing.infrastructure.persistence.seckill.mapper.SeckillGoodsMapper;
import com.andyadc.marketing.infrastructure.persistence.seckill.po.SeckillGoods;
import com.andyadc.marketing.test.TestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class SeckillGoodsMapperTest extends TestBase {

	@Autowired
	SeckillGoodsMapper seckillGoodsMapper;

	@Test
	public void selectByPrimaryKey() {
		SeckillGoods seckillGoods = seckillGoodsMapper.selectByPrimaryKey(1L);
		System.out.println(JsonUtils.toJson(seckillGoods));
	}

}
