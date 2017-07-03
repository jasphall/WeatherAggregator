package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata;

import lombok.Value;

@Value
public class WeatherApiDataWind {

    private Integer chill;
    private Integer direction;
    private Float speed;

}
