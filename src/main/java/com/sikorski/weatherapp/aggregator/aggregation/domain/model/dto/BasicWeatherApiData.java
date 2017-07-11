package com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements.*;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.WeatherResponseStatus;
import com.sikorski.weatherapp.commons.utils.ReflectionUtils;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Obiekt przechowujący podstawowe dane pogodowe
 */
@Getter
public class BasicWeatherApiData implements WeatherApiData {

    /**
     * Lista pól ignorowanych przy ocenie jakości danych
     */
    final static List<String> qualityIgnoredFields = Arrays.asList("dateTime", "status", "qualityIgnoredFields");

    public static BasicWeatherApiData empty() {
        return BasicWeatherApiData.builder().statusNoData().build();
    }

    public static WeatherApiDataBuilder builder() {
        return new WeatherApiDataBuilder();
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

    public BasicWeatherApiData(WeatherApiDataBuilder builder) {
        this.dateTime = builder.getDateTime();
        this.location = builder.getLocation();
        this.wind = builder.getWind();
        this.atmosphere = builder.getAtmosphere();
        this.sunrise = builder.getSunrise();
        this.sunset = builder.getSunset();
        this.temperature = builder.getTemperature();
        this.units = builder.getUnits();
        this.forecasts = builder.getForecasts();
        this.status = builder.getStatus();
    }

    @Override
    public boolean isEmpty() {
        return this.status == WeatherResponseStatus.NO_DATA;
    }

    @Override
    public String getLocationCity() {
        return location == null ? "" : location.getCity();
    }

    @Override
    public List<String> ignoredFieldNames() {
        return qualityIgnoredFields;
    }

    @Override
    public int filledValuesSize() {
        List<Field> fields = Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> !ignoredFieldNames().contains(f.getName()))
                .collect(Collectors.toList());

        return ReflectionUtils.countNotEmptyFieldsInObject(fields, this);
    }

    @Override
    public int allFillableValuesSize() {
        return (int) Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> !ignoredFieldNames().contains(f.getName()))
                .count();
    }
}
