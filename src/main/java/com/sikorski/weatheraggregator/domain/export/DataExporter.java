package com.sikorski.weatheraggregator.domain.export;

import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData;

/**
 * Interfejs do eksportu danych
 */
public interface DataExporter {

    /**
     * Metoda eksportująca dane
     *
     * @param weatherApiData
     *      obiekt transportowy danych pogodowych
     * @param parameters
     *      dodatkowe parametry potrzebne przy eksporcie
     */
    void export(WeatherApiData weatherApiData, ExportParameters parameters);

}
