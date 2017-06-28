package com.sikorski.weatheraggregator.domain.dataaggregation.commands;

import com.sikorski.weatheraggregator.application.cqrs.commands.Command;
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData;
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
