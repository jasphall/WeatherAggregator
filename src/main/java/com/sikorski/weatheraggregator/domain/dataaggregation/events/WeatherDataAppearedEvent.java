package com.sikorski.weatheraggregator.domain.dataaggregation.events;

import com.sikorski.weatheraggregator.application.events.Event;
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData;
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
