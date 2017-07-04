package com.sikorski.weatheraggregator.aggregation.domain.persistence;

import com.sikorski.weatheraggregator.aggregation.domain.model.persistence.WeatherDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataModelRepository extends JpaRepository<WeatherDataModel, Long> {
}
