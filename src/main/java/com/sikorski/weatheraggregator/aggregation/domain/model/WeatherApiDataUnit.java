package com.sikorski.weatheraggregator.aggregation.domain.model;

import lombok.Value;

@Value
public class WeatherApiDataUnit {

    private String value;
    private String unit;

    public static WeatherApiDataUnit of(String value, String unit) {
        return new WeatherApiDataUnit(value, unit);
    }
}
