package com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi;

import com.sikorski.weatherapp.aggregator.aggregation.domain.location.Location;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;

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
