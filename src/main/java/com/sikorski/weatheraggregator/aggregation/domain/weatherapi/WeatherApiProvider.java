package com.sikorski.weatheraggregator.aggregation.domain.weatherapi;

import com.sikorski.weatheraggregator.aggregation.domain.location.Location;
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData;

/**
 * Interfejs do pobierania najświeższych danych pogodowych z zewnętrznego API
 */
public interface WeatherApiProvider {

    /**
     * Metoda pobierająca najświeższe dane pogodowe z API
     *
     * @return
     */
    WeatherApiData getNewestData(Location location);

}
