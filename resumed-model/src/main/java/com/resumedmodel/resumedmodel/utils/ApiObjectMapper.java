package com.resumedmodel.resumedmodel.utils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiObjectMapper<T> {
    @Autowired
    private ObjectMapper mapper;

    @PostConstruct
    private void init() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    public T convert(Object from, Class<T> to) {
        return mapper.convertValue(from, to);
    }

}
