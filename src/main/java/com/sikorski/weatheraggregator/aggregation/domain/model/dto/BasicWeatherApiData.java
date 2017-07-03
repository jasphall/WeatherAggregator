package com.sikorski.weatheraggregator.aggregation.domain.model.dto;

import com.sikorski.weatheraggregator.aggregation.domain.model.*;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherResponseStatus;
import com.sikorski.weatheraggregator.application.dto.SimpleDescriptive;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Obiekt przechowujący podstawowe dane pogodowe
 */
public class BasicWeatherApiData implements WeatherApiData, SimpleDescriptive {

    final static List<String> qualityIgnoredFields = Arrays.asList("dateTime", "status", "qualityIgnoredFields");

    public static BasicWeatherApiData empty() {
        return BasicWeatherApiData.builder().statusNoData().build();
    }

    /**
     * Data i czas odczytu
     */
    private Date dateTime;

    /**
     * Dane o lokalizacji
     */
    private WeatherApiDataLocation location;

    /**
     * Dane o jednostkach
     */
    private List<WeatherApiDataUnit> units;

    /**
     * Dane o wietrze
     */
    private WeatherApiDataWind wind;

    /**
     * Dane atmosferyczne
     */
    private WeatherApiDataAtmosphere atmosphere;

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
     * Prognozy temperatury z API
     */
    private List<WeatherApiDataForecast> forecasts;

    /**
     * Status odczytu
     */
    private WeatherResponseStatus status;

    BasicWeatherApiData(BasicWeatherApiDataBuilder builder) {
        this.dateTime = builder.getDateTime();
        this.location = builder.getLocation();
        this.units = builder.getUnits();
        this.wind = builder.getWind();
        this.atmosphere = builder.getAtmosphere();
        this.sunrise = builder.getSunrise();
        this.sunset = builder.getSunset();
        this.forecasts = builder.getForecasts();
        this.temperature = builder.getTemperature();
        this.status = builder.getStatus();
    }

    public static BasicWeatherApiDataBuilder builder() {
        return new BasicWeatherApiDataBuilder();
    }

    @Override
    public boolean isEmpty() {
        return this.status == WeatherResponseStatus.NO_DATA;
    }

    @Override
    public List<String> ignoredFieldNames() {
        return qualityIgnoredFields;
    }

    @Override
    public int filledValuesSize() {
        int filledValuesSize = 0;

        for (Field field: getClass().getDeclaredFields()) {
            if (!ignoredFieldNames().contains(field.getName())) {
                field.setAccessible(true);

                try {
                    Object value = field.get(this);
                    if (value != null) {
                        filledValuesSize++;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return filledValuesSize;
    }

    @Override
    public int allFillableValuesSize() {
        return (int) Arrays.asList(getClass().getDeclaredFields())
                .stream()
                .filter(f -> !ignoredFieldNames().contains(f.getName()))
                .count();
    }

    @Override
    public String toOneLiner() {
        final char separator = ',';

        if (isEmpty()) {
            return "-" + separator + "-" + separator + "-" + separator + "-" + separator + "-" + separator +
                    status.name() + '\n';
        } else {
            return dateTime.toString() + separator + temperature + separator + status.name() + '\n';
        }
    }

    @Override
    public String toString() {
        return "BasicWeatherApiData{" +
                "dateTime=" + dateTime +
                ", temperature=" + temperature +
                ", status=" + status +
                '}';
    }
}
