package com.sikorski.weatherapp.aggregator.aggregation.domain.persistence;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence.WeatherDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherDataModelRepository extends JpaRepository<WeatherDataModel, Long> {

    List<WeatherDataModel> findByDateTimeBetween(Date startDateTime, Date endDateTime);

}
