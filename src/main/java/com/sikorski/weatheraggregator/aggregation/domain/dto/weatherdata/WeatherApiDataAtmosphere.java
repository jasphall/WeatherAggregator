package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata;

import lombok.Value;

@Value
public class WeatherApiDataAtmosphere {

    private Integer humidity;
    private Float visibility;
    private Float pressure;

}
