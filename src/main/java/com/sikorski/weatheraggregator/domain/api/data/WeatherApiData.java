package com.sikorski.weatheraggregator.domain.api.data;

import com.sikorski.weatheraggregator.domain.api.WeatherResponseStatus;

/**
 * Obiekt przechowujący dane pogodowe
 */
public class WeatherApiData {

    public static final WeatherApiData empty() {
        return new WeatherApiData(WeatherResponseStatus.NO_DATA);
    }

    /**
     * Temperatura
     */
    private Double temperature;

    /**
     * Status odczytu
     */
    private WeatherResponseStatus status;

    public WeatherApiData(WeatherResponseStatus status) {
        this.status = status;
    }
}
