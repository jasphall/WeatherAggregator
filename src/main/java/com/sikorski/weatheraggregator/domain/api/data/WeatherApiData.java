package com.sikorski.weatheraggregator.domain.api.data;

import com.sikorski.weatheraggregator.domain.api.WeatherResponseStatus;
import com.sikorski.weatheraggregator.domain.api.data.builder.WeatherApiDataBuilder;

import java.util.Date;

/**
 * Obiekt przechowujący dane pogodowe
 */
public class WeatherApiData {

    public static final WeatherApiData empty() {
        return new WeatherApiDataBuilder().build();
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

    public WeatherApiData(WeatherApiDataBuilder builder) {
        this.dateTime = builder.getDateTime();
        this.temperature = builder.getTemperature();
        this.minTemperature = builder.getMinTemperature();
        this.maxTemperature = builder.getMaxTemperature();
        this.status = builder.getStatus();
        this.pressure = builder.getPressure();
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public WeatherResponseStatus getStatus() {
        return status;
    }

    public String toOneLinerWithCommaSeparator() {
        final char separator = ',';
        return dateTime.toString() + separator + temperature + separator + minTemperature + separator + maxTemperature +
                separator + pressure + separator + status.name() + '\n';
    }

    @Override
    public String toString() {
        return "WeatherApiData{" +
                "dateTime=" + dateTime +
                ", temperature=" + temperature +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", pressure=" + pressure +
                ", status=" + status +
                '}';
    }
}
