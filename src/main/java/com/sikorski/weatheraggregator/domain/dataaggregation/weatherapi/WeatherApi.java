package com.sikorski.weatheraggregator.domain.dataaggregation.weatherapi;

import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData;

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
