package com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.mapper;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;

/**
 * Interfejs mapujący zewnętrzny format danych pogodowych na format wewnętrzny aplikacji
 * @param <T>
 */
public interface WeatherApiMapper<T> {

    WeatherApiData map(T t);

}
