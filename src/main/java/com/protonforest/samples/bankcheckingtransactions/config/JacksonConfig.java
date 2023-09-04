package com.protonforest.samples.bankcheckingtransactions.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // ISO 8601 date format
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        ;
        return objectMapper;
    }

}
