package com.sikorski.weatherapp.aggregator.qualityscoring.domain;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;

class SimpleDataQualityScoring implements DataQualityScoring {

    @Override
    public double score(WeatherApiData weatherApiData) {
        int ignoredFieldSize = weatherApiData.ignoredFieldNames().size();
        int allFieldSize = weatherApiData.getClass().getDeclaredFields().length;
        int qualityImportantFieldSize = allFieldSize - ignoredFieldSize;

        return 1.0 * weatherApiData.filledValuesSize() / qualityImportantFieldSize;
    }
}
