package com.sikorski.weatherapp.aggregator.aggregation.domain.events;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatherapp.aggregator.application.events.Event;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class WeatherDataAppearedEvent implements Event {

    private LocalDateTime when;
    private WeatherApiData weatherData;

    @Override
    public LocalDateTime when() {
        return when;
    }
}
