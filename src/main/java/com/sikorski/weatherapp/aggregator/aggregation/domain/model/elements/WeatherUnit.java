package com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatherapp.aggregator.application.persistence.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WeatherUnits")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherUnit extends BaseEntity {

    private String value;
    private String unit;

    @ManyToOne
    private WeatherDataModel weatherDataModel;

    public static WeatherUnit of(String value, String unit) {
        return new WeatherUnit(value, unit);
    }

    private WeatherUnit(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }
}
