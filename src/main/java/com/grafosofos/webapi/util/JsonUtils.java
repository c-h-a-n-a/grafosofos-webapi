package com.grafosofos.webapi.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<String> parseOptions(String jsonOptions) throws IOException {
        return objectMapper.readValue(jsonOptions, new TypeReference<List<String>>() {});
    }
}