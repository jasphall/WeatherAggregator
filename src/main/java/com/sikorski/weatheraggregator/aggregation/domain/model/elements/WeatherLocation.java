package com.sikorski.weatheraggregator.aggregation.domain.model.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WeatherLocation {

    private String city;
    private String region;
    private String country;

}
