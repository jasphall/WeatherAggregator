package com.sikorski.weatheraggregator.aggregation.domain.model.dto;

import com.sikorski.weatheraggregator.aggregation.domain.model.WeatherDataBuilder;
import com.sikorski.weatheraggregator.aggregation.domain.model.elements.*;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherResponseStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Budowniczy obiektu transportowego danych pogodowych z API
 */
@Getter
public class WeatherApiDataBuilder implements WeatherDataBuilder<BasicWeatherApiData> {

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

    WeatherApiDataBuilder() {
    }

    public WeatherApiDataBuilder withDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public WeatherApiDataBuilder withLocation(WeatherLocation location) {
        this.location = location;
        return this;
    }

    public WeatherApiDataBuilder withUnits(List<WeatherUnit> units) {
        this.units = units;
        return this;
    }

    public WeatherApiDataBuilder withWind(WeatherWind wind) {
        this.wind = wind;
        return this;
    }

    public WeatherApiDataBuilder withAtmosphere(WeatherAtmosphere atmosphere) {
        this.atmosphere = atmosphere;
        return this;
    }

    public WeatherApiDataBuilder withSunrise(Date sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public WeatherApiDataBuilder withSunset(Date sunset) {
        this.sunset = sunset;
        return this;
    }

    public WeatherApiDataBuilder withForecasts(List<WeatherForecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }

    public WeatherApiDataBuilder withTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public WeatherApiDataBuilder statusOK() {
        this.status = WeatherResponseStatus.OK;
        return this;
    }

    public WeatherApiDataBuilder statusNoData() {
        this.status = WeatherResponseStatus.NO_DATA;
        return this;
    }

    @Override
    public BasicWeatherApiData build() {
        return new BasicWeatherApiData(this);
    }
}
