package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata;

import com.sikorski.weatheraggregator.application.dto.SimpleDescriptive;
import com.sikorski.weatheraggregator.qualityscoring.domain.QualityMeasurable;

/**
 * Interfejs danej odczytanej z punktu pomiarowego
 */
public interface WeatherApiData extends SimpleDescriptive, QualityMeasurable {

    /**
     * Określa, czy wpis nie zawiera żadnych danych pomiarowych
     * @return
     */
    boolean isEmpty();

}
