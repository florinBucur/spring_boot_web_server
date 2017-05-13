package com.innovation.evconnect.serializer;

import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class BCryptPasswordDeserializer extends JsonDeserializer<String> {

	@Override
	public String deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		String encodedPassword = encoder.encode(node.asText());
		return encodedPassword;
	}

}
