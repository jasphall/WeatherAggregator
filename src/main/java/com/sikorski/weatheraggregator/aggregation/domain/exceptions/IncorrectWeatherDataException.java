package com.sikorski.weatheraggregator.aggregation.domain.exceptions;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;

/**
 * Wyjątek generowany, gdy dane {@link WeatherApiData}
 * są niepoprawne
 */
public class IncorrectWeatherDataException extends RuntimeException {
}
