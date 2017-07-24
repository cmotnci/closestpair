package com.closestpair.configuration;

import com.closestpair.service.DistanceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    DistanceService distanceService() {
        return new DistanceService();
    }
}
