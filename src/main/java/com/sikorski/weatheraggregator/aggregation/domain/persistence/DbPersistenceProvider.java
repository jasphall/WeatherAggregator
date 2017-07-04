package com.sikorski.weatheraggregator.aggregation.domain.persistence;

import com.sikorski.weatheraggregator.aggregation.domain.model.dto.BasicWeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatheraggregator.application.dto.NamedParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DbPersistenceProvider implements DataPersistenceProvider {

    private final WeatherDataModelRepository weatherDataModelRepository;

    @Autowired
    public DbPersistenceProvider(WeatherDataModelRepository weatherDataModelRepository) {
        this.weatherDataModelRepository = weatherDataModelRepository;
    }

    @Override
    public WeatherDataModel persist(WeatherApiData weatherApiData, NamedParameters parameters) {
        WeatherDataModel weatherDataModel = WeatherDataModel.builder()
                .fromWeatherApiData((BasicWeatherApiData) weatherApiData)
                .build();

        return weatherDataModelRepository.save(weatherDataModel);
    }

}
