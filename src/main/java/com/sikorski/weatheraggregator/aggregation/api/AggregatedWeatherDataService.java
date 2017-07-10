package com.sikorski.weatheraggregator.aggregation.api;

import com.sikorski.weatheraggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatheraggregator.aggregation.domain.persistence.WeatherDataModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
class AggregatedWeatherDataService {

    private final WeatherDataModelRepository weatherDataModelRepository;

    @Autowired
    AggregatedWeatherDataService(WeatherDataModelRepository weatherDataModelRepository) {
        this.weatherDataModelRepository = weatherDataModelRepository;
    }

    List<AggregatedWeatherData> getWeatherDataInTimeRange(Date startDateTime, Date endDateTime) {
        List<WeatherDataModel> weatherDataModels = weatherDataModelRepository
                .findByDateTimeBetween(startDateTime, endDateTime);

        return weatherDataModels.stream()
                .map(AggregatedWeatherData::from)
                .collect(Collectors.toList());
    }

}
