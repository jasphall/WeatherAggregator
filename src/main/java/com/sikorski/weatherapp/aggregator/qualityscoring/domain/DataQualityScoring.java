package com.sikorski.weatherapp.aggregator.qualityscoring.domain;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;

public interface DataQualityScoring {

    double score(WeatherApiData weatherApiData);

}
