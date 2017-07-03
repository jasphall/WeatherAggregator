package com.sikorski.weatheraggregator.qualityscoring.domain;

import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData;

public interface DataQualityScoring {

    double score(WeatherApiData weatherApiData);

}
