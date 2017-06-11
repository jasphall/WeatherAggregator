package com.sikorski.weatheraggregator.domain.api.data.builder;

import com.sikorski.weatheraggregator.domain.api.WeatherResponseStatus;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;

import java.util.Date;

/**
 * Builder dla tworzenia obiektu transportowego danych pogodowych
 */
public class WeatherApiDataBuilder {

    private Date dateTime;
    private Double temperature;
    private Double minTemperature;
    private Double maxTemperature;
    private Double pressure;
    private WeatherResponseStatus status;

    public WeatherApiDataBuilder() {
    }

    public WeatherApiDataBuilder withDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public WeatherApiDataBuilder withTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public WeatherApiDataBuilder withMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    public WeatherApiDataBuilder withMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    public WeatherApiDataBuilder withPressure(Double pressure) {
        this.pressure = pressure;
        return this;
    }

    public WeatherApiDataBuilder statusOK() {
        this.status = WeatherResponseStatus.OK;
        return this;
    }

    public WeatherApiData build() {
        return new WeatherApiData(this);
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
}
