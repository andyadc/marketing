package com.andyadc.codecraft.base.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public final class JsonUtils {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	private final static String DATE_PATTERN = "yyyy-MM-dd";
	private final static String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private final static ObjectMapper DEFAULT_OBJECT_MAPPER = defaultObjectMapper();

	public static ObjectMapper defaultObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_PATTERN)));
		javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_PATTERN)));
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(TIME_PATTERN)));
		javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(TIME_PATTERN)));
		objectMapper.registerModule(javaTimeModule);

		return objectMapper;
	}

	public static String toJson(Object object) {
		if (object == null) return null;
		if (object instanceof String) return (String) object;
		try {
			return DEFAULT_OBJECT_MAPPER.writeValueAsString(object);
		} catch (Exception e) {
			logger.error("Write to json string error: " + object, e);
			return "";
		}
	}

	public static <T> T toObject(Object object, Class<T> clazz) {
		if (object == null) return null;
		if (!(object instanceof String)) {
			return (T) object;
		}
		String json = (String) object;
		if (json.isEmpty()) {
			return null;
		} else {
			try {
				return DEFAULT_OBJECT_MAPPER.readValue(json, clazz);
			} catch (Exception e) {
				logger.error("parse json string error: " + json, e);
				return null;
			}
		}
	}

	public static <T> T toObject(Object object, JavaType javaType) {
		if (object == null) return null;
		if (!(object instanceof String)) {
			return (T) object;
		}
		String json = (String) object;
		if (json.isEmpty()) {
			return null;
		} else {
			try {
				return DEFAULT_OBJECT_MAPPER.readValue(json, javaType);
			} catch (Exception e) {
				logger.error("parse json string error: " + json, e);
				return null;
			}
		}
	}

	public <T> T toPojo(Object object, TypeReference<T> typeReference) {
		if (object == null) return null;
		if (!(object instanceof String)) {
			return (T) object;
		}
		String json = (String) object;
		if (json.isEmpty()) {
			return null;
		} else {
			try {
				return DEFAULT_OBJECT_MAPPER.readValue(json, typeReference);
			} catch (Exception e) {
				logger.error("parse json string error: " + json, e);
				return null;
			}
		}
	}

}
