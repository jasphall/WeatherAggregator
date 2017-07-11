package com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class WeatherAtmosphere {

    private Integer humidity;
    private Float visibility;
    private Float pressure;

}
