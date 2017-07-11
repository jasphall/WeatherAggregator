package com.sikorski.weatherapp.aggregator.aggregation.domain.commands;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatherapp.aggregator.application.cqrs.commands.Command;
import lombok.Value;

/**
 * Komenda zapisu danych pogodowych
 */
@Value
public class SaveWeatherCommand implements Command {

    /**
     * Dane pogodowe
     */
    private WeatherApiData weatherData;

}
