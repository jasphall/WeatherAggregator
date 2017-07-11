package com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.WeatherDataBuilder;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.BasicWeatherApiData;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements.*;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.WeatherResponseStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Budowniczy obiektu encji danych pogodowych
 */
@Getter
public class WeatherModelDataBuilder implements WeatherDataBuilder<WeatherDataModel> {

    private Date dateTime;
    private WeatherLocation location;
    private WeatherWind wind;
    private WeatherAtmosphere atmosphere;
    private Date sunrise;
    private Date sunset;
    private Double temperature;
    private List<WeatherUnit> units = new ArrayList<>();
    private List<WeatherForecast> forecasts = new ArrayList<>();
    private WeatherResponseStatus status;

    public WeatherModelDataBuilder() {}

    public WeatherModelDataBuilder withDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public WeatherModelDataBuilder withLocation(WeatherLocation location) {
        this.location = location;
        return this;
    }

    public WeatherModelDataBuilder withUnits(List<WeatherUnit> units) {
        this.units = units;
        return this;
    }

    public WeatherModelDataBuilder withWind(WeatherWind wind) {
        this.wind = wind;
        return this;
    }

    public WeatherModelDataBuilder withAtmosphere(WeatherAtmosphere atmosphere) {
        this.atmosphere = atmosphere;
        return this;
    }

    public WeatherModelDataBuilder withSunrise(Date sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public WeatherModelDataBuilder withSunset(Date sunset) {
        this.sunset = sunset;
        return this;
    }

    public WeatherModelDataBuilder withForecasts(List<WeatherForecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }

    public WeatherModelDataBuilder withTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public WeatherModelDataBuilder statusOK() {
        this.status = WeatherResponseStatus.OK;
        return this;
    }

    public WeatherModelDataBuilder statusNoData() {
        this.status = WeatherResponseStatus.NO_DATA;
        return this;
    }

    @Override
    public WeatherDataModel build() {
        return new WeatherDataModel(this);
    }

    public WeatherModelDataBuilder fromWeatherApiData(BasicWeatherApiData weatherApiData) {
        withAtmosphere(weatherApiData.getAtmosphere());
        withDateTime(weatherApiData.getDateTime());
        withForecasts(weatherApiData.getForecasts());
        withLocation(weatherApiData.getLocation());
        withSunrise(weatherApiData.getSunrise());
        withSunset(weatherApiData.getSunset());
        withTemperature(weatherApiData.getTemperature());
        withUnits(weatherApiData.getUnits());
        withWind(weatherApiData.getWind());
        statusOK();

        return this;
    }

}
