package com.protonforest.samples.bankcheckingtransactions.config;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.influx.InfluxConfig;
import io.micrometer.influx.InfluxMeterRegistry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InfluxInitializer {

    public InfluxInitializer(Influx influx) {

        InfluxConfig config = new InfluxConfig() {
            @Override
            public String org() {
                return influx.getOrg();
            }

            @Override
            public String bucket() {
                return influx.getBucket();
            }

            @Override
            public String token() {
                return influx.getToken(); 
            }

            @Override
            public String get(String k) {
                return null; // accept the rest of the defaults
            }
        };
        
        MeterRegistry registry = new InfluxMeterRegistry(config, Clock.SYSTEM);
        log.info("Initialized Metometer Influx interface.");
    }

}