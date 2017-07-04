package com.sikorski.weatheraggregator.aggregation.domain.model.dto;

import com.sikorski.weatheraggregator.qualityscoring.domain.QualityMeasurable;

/**
 * Interfejs danej odczytanej z punktu pomiarowego
 */
public interface WeatherApiData extends QualityMeasurable {

    /**
     * Określa, czy wpis nie zawiera żadnych danych pomiarowych
     * @return
     */
    boolean isEmpty();

}
