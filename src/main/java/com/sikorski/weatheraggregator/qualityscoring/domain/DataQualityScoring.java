package com.sikorski.weatheraggregator.qualityscoring.domain;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;

public interface DataQualityScoring {

    double score(WeatherApiData weatherApiData);

}
