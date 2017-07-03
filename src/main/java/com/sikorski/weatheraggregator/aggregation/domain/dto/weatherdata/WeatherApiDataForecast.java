package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata;

import lombok.Value;

import java.util.Date;

@Value
public class WeatherApiDataForecast {

    private Date date;
    private Integer minTemperature;
    private Integer maxTemperature;

}
