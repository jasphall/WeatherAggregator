package com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto;

import com.sikorski.weatherapp.aggregator.qualityscoring.domain.QualityMeasurable;

/**
 * Interfejs danej odczytanej z punktu pomiarowego
 */
public interface WeatherApiData extends QualityMeasurable {

    /**
     * Określa, czy wpis nie zawiera żadnych danych pomiarowych
     * @return
     */
    boolean isEmpty();

    /**
     * Pobiera nazwę lokalizacji, której dotyczy wpis
     * @return
     */
    String getLocationCity();

}
