package com.sikorski.weatheraggregator.aggregation.domain.model;

/**
 * Budowniczy danych pogodowych
 * @param <T> - typ zwracany
 */
public interface WeatherDataBuilder<T> {

    T build();

}
