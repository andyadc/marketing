package com.andyadc.marketing.infrastructure.config;

import com.andyadc.codecraft.base.core.serializer.JodaDateTimeJsonDeserializer;
import com.andyadc.codecraft.base.core.serializer.JodaDateTimeJsonSerializer;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringRedisSerializer);

		ObjectMapper objectMapper = new ObjectMapper();

		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(DateTime.class, new JodaDateTimeJsonSerializer());
		simpleModule.addDeserializer(DateTime.class, new JodaDateTimeJsonDeserializer());
		objectMapper.registerModule(simpleModule);

		// Deprecated
//		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		PolymorphicTypeValidator typeValidator = BasicPolymorphicTypeValidator.builder()
			.allowIfSubType(String.class)
			.allowIfSubType(ArrayList.class)
			// ... allow other safe types
			.build();
		objectMapper.activateDefaultTyping(typeValidator, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		return redisTemplate;
	}

}
