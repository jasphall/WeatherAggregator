package com.sikorski.weatheraggregator.aggregation.domain.model.dto;

import com.sikorski.weatheraggregator.aggregation.domain.model.*;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherResponseStatus;

import java.util.Date;
import java.util.List;

public class BasicWeatherApiDataBuilder {

    private Date dateTime;
    private WeatherApiDataLocation location;
    private List<WeatherApiDataUnit> units;
    private WeatherApiDataWind wind;
    private WeatherApiDataAtmosphere atmosphere;
    private Date sunrise;
    private Date sunset;
    private Double temperature;
    private List<WeatherApiDataForecast> forecasts;
    private WeatherResponseStatus status;

    BasicWeatherApiDataBuilder() {
    }

    public BasicWeatherApiDataBuilder withDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public BasicWeatherApiDataBuilder withLocation(WeatherApiDataLocation location) {
        this.location = location;
        return this;
    }

    public BasicWeatherApiDataBuilder withUnits(List<WeatherApiDataUnit> units) {
        this.units = units;
        return this;
    }

    public BasicWeatherApiDataBuilder withWind(WeatherApiDataWind wind) {
        this.wind = wind;
        return this;
    }

    public BasicWeatherApiDataBuilder withAtmosphere(WeatherApiDataAtmosphere atmosphere) {
        this.atmosphere = atmosphere;
        return this;
    }

    public BasicWeatherApiDataBuilder withSunrise(Date sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public BasicWeatherApiDataBuilder withSunset(Date sunset) {
        this.sunset = sunset;
        return this;
    }

    public BasicWeatherApiDataBuilder withForecasts(List<WeatherApiDataForecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }

    public BasicWeatherApiDataBuilder withTemperature(Double temperature) {
        this.temperature = temperature;
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

    public WeatherApiDataLocation getLocation() {
        return location;
    }

    public List<WeatherApiDataUnit> getUnits() {
        return units;
    }

    public WeatherApiDataWind getWind() {
        return wind;
    }

    public WeatherApiDataAtmosphere getAtmosphere() {
        return atmosphere;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public Double getTemperature() {
        return temperature;
    }

    public List<WeatherApiDataForecast> getForecasts() {
        return forecasts;
    }

    public WeatherResponseStatus getStatus() {
        return status;
    }
}
