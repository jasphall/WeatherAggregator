package com.sikorski.weatheraggregator.domain.api.services.yahoo;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.config.logs.Loggable;
import com.sikorski.weatheraggregator.domain.api.services.yahoo.exceptions.YahooApiLocationUnavailableException;

/**
 * Serwis zarządzający API Yahoo Weather
 */
public interface YahooApiManager extends Loggable {

    /**
     * Udostępnia obecny stan pogodowy w danej lokalizacji i jednostce temperatury
     *
     * @param location
     * @param degreeUnit
     * @return
     */
    Channel getLocationCurrentWeather(String location, DegreeUnit degreeUnit) throws YahooApiLocationUnavailableException;

}
