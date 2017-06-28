package com.sikorski.weatheraggregator.domain.dataaggregation.weatherapi.scheduler;

/**
 * Obiekt wykonujący czasowe zapytania do API o najświeższe dane
 */
public interface GetDataScheduler {

    /**
     * Metoda pobierająca najświeższe dane z API
     */
    void getData();

}
