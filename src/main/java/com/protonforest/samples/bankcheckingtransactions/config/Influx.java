package com.protonforest.samples.bankcheckingtransactions.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class Influx {

    @Value("${management.influx.metrics.export.token}")
    String token;

    @Value("${management.influx.metrics.export.bucket}")
    String bucket;

    @Value("${management.influx.metrics.export.org}")
    String org;

}
