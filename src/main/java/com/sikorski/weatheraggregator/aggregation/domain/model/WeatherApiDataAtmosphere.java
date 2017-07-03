package com.sikorski.weatheraggregator.aggregation.domain.model;

import lombok.Value;

@Value
public class WeatherApiDataAtmosphere {

    private Integer humidity;
    private Float visibility;
    private Float pressure;

}
