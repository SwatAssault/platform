package com.project.platfrom.base.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.platfrom.base.exception.JsonDeserializeException;
import com.project.platfrom.base.exception.JsonSerializeException;

public final class JsonMarshaller {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .registerModule(new JavaTimeModule())
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
            .disable(SerializationFeature.INDENT_OUTPUT)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static <T> String marshall(T serializableObject) {
        try {
            return MAPPER.writeValueAsString(serializableObject);
        } catch (JsonProcessingException ex) {
            throw new JsonSerializeException("Failed to marshalling pojo. Object details: {0}");
        }
    }

    public static <T> T unmarshall(String json, Class<T> targetType) {
        try {
            return MAPPER.readValue(json, targetType);
        } catch (JsonProcessingException ex) {
            throw new JsonDeserializeException("Failed to unmarshall json text to type {1}. Json: {0}");
        }
    }

    public static <T> T unmarshall(String json, TypeReference<T> typeReference) {
        try {
            return MAPPER.readValue(json, typeReference);
        } catch (JsonProcessingException ex) {
            throw new JsonDeserializeException("Failed to unmarshall json text to type {1}. Json: {0}");
        }
    }

    private JsonMarshaller() throws IllegalAccessException {
        throw new IllegalAccessException("You cannot create any instance of Marshaller class.");
    }
}
