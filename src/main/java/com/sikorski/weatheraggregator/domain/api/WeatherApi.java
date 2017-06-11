package com.sikorski.weatheraggregator.domain.api;

import com.sikorski.weatheraggregator.config.Loggable;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;

/**
 * Interfejs do pobierania najświeższych danych pogodowych z zewnętrznego API
 */
public interface WeatherApi extends Loggable {

    /**
     * Metoda pobierająca najświeższe dane pogodowe z API
     *
     * @return
     */
    WeatherApiData getNewestData();

}
