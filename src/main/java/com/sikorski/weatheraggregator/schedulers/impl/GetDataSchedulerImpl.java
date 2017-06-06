package com.sikorski.weatheraggregator.schedulers.impl;

import com.sikorski.weatheraggregator.domain.aggregator.WeatherAggregator;
import com.sikorski.weatheraggregator.domain.api.WeatherApi;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.schedulers.GetDataScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GetDataSchedulerImpl implements GetDataScheduler {

    private final WeatherApi weatherApi;
    private final WeatherAggregator weatherAggregator;

    @Autowired
    public GetDataSchedulerImpl(WeatherApi weatherApi, WeatherAggregator weatherAggregator) {
        this.weatherApi = weatherApi;
        this.weatherAggregator = weatherAggregator;
    }

    @Override
    @Scheduled(fixedDelay = 5000)
    public void getData() {
        logger().info(getClass().getSimpleName() + " execution.");
        WeatherApiData weatherApiData = weatherApi.getNewestData();
        weatherAggregator.onData(weatherApiData);
    }

}
