package com.sikorski.weatherapp.aggregator.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class ApplicationProperties implements ConfigurationProperties {

    @Value("${weather.location}")
    private String weatherLocation;

    public String getLocation() {
        return weatherLocation;
    }

}
