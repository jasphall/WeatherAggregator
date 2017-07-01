package com.sikorski.weatheraggregator.aggregation.domain.commands;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.application.cqrs.commands.Command;
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

    /**
     * Nazwa docelowego pliku csv
     */
    private String filename;

}
