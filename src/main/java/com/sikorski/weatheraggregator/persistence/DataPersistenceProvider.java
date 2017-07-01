package com.sikorski.weatheraggregator.persistence;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.application.dto.NamedParameters;

/**
 * Interfejs do utrwalania danych pogodowych
 */
public interface DataPersistenceProvider {

    /**
     * Zapis danych
     *
     * @param weatherApiData
     *      obiekt transportowy danych pogodowych
     * @param parameters
     *      dodatkowe parametry potrzebne przy eksporcie
     */
    void persist(WeatherApiData weatherApiData, NamedParameters parameters);

}
