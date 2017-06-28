package com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata;

import com.sikorski.weatheraggregator.domain.dataaggregation.dto.SimpleDescriptive;

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
