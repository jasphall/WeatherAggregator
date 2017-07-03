package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata;

import lombok.Value;

@Value
public class WeatherApiDataLocation {

    private String city;
    private String region;
    private String country;

}
