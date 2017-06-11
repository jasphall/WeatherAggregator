package com.sikorski.weatheraggregator.schedulers;

import com.sikorski.weatheraggregator.config.Loggable;

/**
 * Obiekt wykonujący czasowe zapytania do API o najświeższe dane
 */
public interface GetDataScheduler extends Loggable {

    /**
     * Metoda pobierająca najświeższe dane z API
     */
    void getData();

}
