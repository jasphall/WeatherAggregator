package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata;

import com.sikorski.weatheraggregator.application.dto.SimpleDescriptive;

/**
 * Interfejs danej odczytanej z punktu pomiarowego
 */
public interface WeatherApiData extends SimpleDescriptive {

    /**
     * Określa, czy wpis nie zawiera żadnych danych pomiarowych
     * @return
     */
    boolean isEmpty();

}
