package com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatherapp.aggregator.application.persistence.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "WeatherForecasts")
@NoArgsConstructor
@Getter
@Setter
public class WeatherForecast extends BaseEntity {

    private Date date;
    private Integer minTemperature;
    private Integer maxTemperature;

    @ManyToOne
    private WeatherDataModel weatherDataModel;

    public static WeatherForecast of(Date date, Integer minTemperature, Integer maxTemperature) {
        return new WeatherForecast(date, minTemperature, maxTemperature);
    }

    private WeatherForecast(Date date, Integer minTemperature, Integer maxTemperature) {
        this.date = date;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }
}
