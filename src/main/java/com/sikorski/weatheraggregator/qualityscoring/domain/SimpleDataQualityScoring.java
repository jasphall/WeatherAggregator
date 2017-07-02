package com.sikorski.weatheraggregator.qualityscoring.domain;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;

class SimpleDataQualityScoring implements DataQualityScoring {

    @Override
    public double score(WeatherApiData weatherApiData) {
        int ignoredFieldSize = weatherApiData.ignoredFieldNames().size();
        int allFieldSize = weatherApiData.getClass().getDeclaredFields().length;
        int qualityImportantFieldSize = allFieldSize - ignoredFieldSize;

        return 1.0 * weatherApiData.filledValuesSize() / qualityImportantFieldSize;
    }
}