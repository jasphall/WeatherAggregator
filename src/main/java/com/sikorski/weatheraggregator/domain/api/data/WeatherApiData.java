package com.sikorski.weatheraggregator.domain.api.data;

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
