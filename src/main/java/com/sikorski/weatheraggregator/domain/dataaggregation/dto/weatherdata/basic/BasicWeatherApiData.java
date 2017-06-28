package com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.basic;

import com.sikorski.weatheraggregator.domain.dataaggregation.dto.SimpleDescriptive;
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.basic.builder.BasicWeatherApiDataBuilder;
import com.sikorski.weatheraggregator.domain.dataaggregation.weatherapi.WeatherResponseStatus;

import java.util.Date;

/**
 * Obiekt przechowujący podstawowe dane pogodowe
 */
public class BasicWeatherApiData implements WeatherApiData, SimpleDescriptive {

    public static BasicWeatherApiData empty() {
        return new BasicWeatherApiDataBuilder().statusNoData().build();
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

    public BasicWeatherApiData(BasicWeatherApiDataBuilder builder) {
        this.dateTime = builder.getDateTime();
        this.temperature = builder.getTemperature();
        this.minTemperature = builder.getMinTemperature();
        this.maxTemperature = builder.getMaxTemperature();
        this.status = builder.getStatus();
        this.pressure = builder.getPressure();
    }

    @Override
    public boolean isEmpty() {
        return this.status == WeatherResponseStatus.NO_DATA;
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
