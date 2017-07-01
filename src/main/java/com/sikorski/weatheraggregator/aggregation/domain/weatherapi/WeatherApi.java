package com.sikorski.weatheraggregator.aggregation.domain.weatherapi;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;

/**
 * Interfejs do pobierania najświeższych danych pogodowych z zewnętrznego API
 */
public interface WeatherApi {

    /**
     * Metoda pobierająca najświeższe dane pogodowe z API
     *
     * @return
     */
    WeatherApiData getNewestData();

}
