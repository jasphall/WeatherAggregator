package com.sikorski.weatheraggregator.aggregation.domain.scheduler;

/**
 * Obiekt wykonujący czasowe zapytania do API o najświeższe dane
 */
public interface GetDataScheduler {

    /**
     * Metoda pobierająca najświeższe dane z API
     */
    void getData();

}
