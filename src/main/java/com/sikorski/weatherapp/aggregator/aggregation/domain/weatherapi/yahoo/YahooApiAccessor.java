package com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatherapp.aggregator.aggregation.domain.location.Location;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.exceptions.YahooApiLocationUnavailableException;

/**
 * Serwis zarządzający API Yahoo Weather
 */
public interface YahooApiAccessor {

    /**
     * Udostępnia obecny stan pogodowy w danej lokalizacji i jednostce temperatury
     *
     * @param location
     * @param degreeUnit
     * @return
     */
    Channel getLocationCurrentWeather(Location location, DegreeUnit degreeUnit) throws YahooApiLocationUnavailableException;

}
