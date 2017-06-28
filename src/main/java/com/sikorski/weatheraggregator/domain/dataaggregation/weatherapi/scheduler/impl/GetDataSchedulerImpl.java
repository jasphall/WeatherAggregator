package com.sikorski.weatheraggregator.domain.dataaggregation.weatherapi.scheduler.impl;

import com.sikorski.weatheraggregator.application.events.bus.EventPublisher;
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.domain.dataaggregation.events.WeatherDataAppearedEvent;
import com.sikorski.weatheraggregator.domain.dataaggregation.weatherapi.WeatherApi;
import com.sikorski.weatheraggregator.domain.dataaggregation.weatherapi.scheduler.GetDataScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
class GetDataSchedulerImpl implements GetDataScheduler {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    @Qualifier(value = "yahoo")
    private WeatherApi weatherApi;

    @Override
    @Scheduled(fixedDelay = 900000)
    public void getData() {
        log.info(getClass().getSimpleName() + " execution.");
        WeatherApiData weatherApiData = weatherApi.getNewestData();

        eventPublisher.publishEvent(new WeatherDataAppearedEvent(LocalDateTime.now(), weatherApiData));
    }

}
