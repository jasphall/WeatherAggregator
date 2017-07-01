package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic;

import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherResponseStatus;

import java.util.Date;

public class BasicWeatherApiDataBuilder {

    private Date dateTime;
    private Double temperature;
    private Double minTemperature;
    private Double maxTemperature;
    private Double pressure;
    private WeatherResponseStatus status;

    BasicWeatherApiDataBuilder() {
    }

    public BasicWeatherApiDataBuilder withDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public BasicWeatherApiDataBuilder withTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public BasicWeatherApiDataBuilder withMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    public BasicWeatherApiDataBuilder withMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    public BasicWeatherApiDataBuilder withPressure(Double pressure) {
        this.pressure = pressure;
        return this;
    }

    public BasicWeatherApiDataBuilder statusOK() {
        this.status = WeatherResponseStatus.OK;
        return this;
    }

    public BasicWeatherApiDataBuilder statusNoData() {
        this.status = WeatherResponseStatus.NO_DATA;
        return this;
    }

    public BasicWeatherApiData build() {
        return new BasicWeatherApiData(this);
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
