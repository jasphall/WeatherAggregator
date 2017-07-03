package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.mapper;

import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData;

/**
 * Interfejs mapujący zewnętrzny format danych pogodowych na format wewnętrzny aplikacji
 * @param <T>
 */
public interface WeatherApiMapper<T> {

    WeatherApiData map(T t);

}
