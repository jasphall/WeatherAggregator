package com.sikorski.weatheraggregator.aggregation.api;

import com.sikorski.weatheraggregator.aggregation.domain.model.elements.*;
import com.sikorski.weatheraggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherResponseStatus;
import lombok.Value;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Value
class AggregatedWeatherData {

    static AggregatedWeatherData from(WeatherDataModel weatherDataModel) {
        return new AggregatedWeatherData(
                weatherDataModel.getDateTime(),
                weatherDataModel.getLocation(),
                weatherDataModel.getWind(),
                weatherDataModel.getAtmosphere(),
                weatherDataModel.getSunrise(),
                weatherDataModel.getSunset(),
                weatherDataModel.getTemperature(),
                weatherDataModel.getStatus());
    }

    /**
     * Data i czas odczytu
     */
    private Date dateTime;

    /**
     * Dane o lokalizacji
     */
    private WeatherLocation location;

    /**
     * Dane o wietrze
     */
    private WeatherWind wind;

    /**
     * Dane atmosferyczne
     */
    private WeatherAtmosphere atmosphere;

    /**
     * Wschód słońca
     */
    private Date sunrise;

    /**
     * Zachód słońca
     */
    private Date sunset;

    /**
     * Temperatura
     */
    private Double temperature;

    /**
     * Dane o jednostkach
     */
    private List<WeatherUnit> units = new ArrayList<>();

    /**
     * Prognozy temperatury z API
     */
    private List<WeatherForecast> forecasts = new ArrayList<>();

    /**
     * Status odczytu
     */
    private WeatherResponseStatus status;

}
