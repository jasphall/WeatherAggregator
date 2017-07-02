package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;
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
     * Temperatura
     */
    private Double temperature;

    /**
     * Minimalna temperatura
     */
    private Double minTemperature;

    /**
     * Maksymalna temperatura
     */
    private Double maxTemperature;

    /**
     * Ciśnienie
     */
    private Double pressure;

    /**
     * Status odczytu
     */
    private WeatherResponseStatus status;

    BasicWeatherApiData(BasicWeatherApiDataBuilder builder) {
        this.dateTime = builder.getDateTime();
        this.temperature = builder.getTemperature();
        this.minTemperature = builder.getMinTemperature();
        this.maxTemperature = builder.getMaxTemperature();
        this.status = builder.getStatus();
        this.pressure = builder.getPressure();
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
    public String toOneLiner() {
        final char separator = ',';

        if (isEmpty()) {
            return "-" + separator + "-" + separator + "-" + separator + "-" + separator + "-" + separator +
                    status.name() + '\n';
        } else {
            return dateTime.toString() + separator + temperature + separator + minTemperature + separator +
                    maxTemperature + separator + pressure + separator + status.name() + '\n';
        }
    }

    @Override
    public String toString() {
        return "BasicWeatherApiData{" +
                "dateTime=" + dateTime +
                ", temperature=" + temperature +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", pressure=" + pressure +
                ", status=" + status +
                '}';
    }
}
