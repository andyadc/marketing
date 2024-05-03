package com.andyadc.dddframework.base.core.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class JodaDateTimeJsonDeserializer extends JsonDeserializer<DateTime> {

	@Override
	public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
		String dataString = jsonParser.readValueAs(String.class);
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		return DateTime.parse(dataString, formatter);
	}
}
