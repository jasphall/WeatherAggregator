package com.sikorski.weatherapp.aggregator.aggregation.domain.persistence;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatherapp.aggregator.application.dto.NamedParameters;

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
    WeatherDataModel persist(WeatherApiData weatherApiData, NamedParameters parameters);

}
