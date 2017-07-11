package com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements.*;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.WeatherResponseStatus;
import com.sikorski.weatherapp.aggregator.application.persistence.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "WEATHER_DATA")
@NoArgsConstructor
@Getter
public class WeatherDataModel extends BaseEntity {

    public static WeatherModelDataBuilder builder() {
        return new WeatherModelDataBuilder();
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Embedded
    private WeatherLocation location;

    @Embedded
    private WeatherWind wind;

    @Embedded
    private WeatherAtmosphere atmosphere;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sunrise;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sunset;

    private Double temperature;

    @Enumerated(EnumType.STRING)
    private WeatherResponseStatus status;

    @OneToMany(mappedBy = "weatherDataModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherForecast> forecasts = new ArrayList<>();

    @OneToMany(mappedBy = "weatherDataModel", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherUnit> units = new ArrayList<>();

    WeatherDataModel(WeatherModelDataBuilder builder) {
        this.dateTime = builder.getDateTime();
        this.location = builder.getLocation();
        this.wind = builder.getWind();
        this.atmosphere = builder.getAtmosphere();
        this.sunrise = builder.getSunrise();
        this.sunset = builder.getSunset();
        this.temperature = builder.getTemperature();
        this.status = builder.getStatus();
        this.forecasts = builder.getForecasts();
        this.units = builder.getUnits();
    }

    @Override
    protected void updateForeignKeysBeforePersist() {
        this.forecasts.forEach(f -> f.setWeatherDataModel(this));
        this.units.forEach(u -> u.setWeatherDataModel(this));
    }
}