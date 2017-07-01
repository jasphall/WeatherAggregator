package com.sikorski.weatheraggregator.aggregation.domain.scheduler;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.events.WeatherDataAppearedEvent;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherApi;
import com.sikorski.weatheraggregator.application.events.bus.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
class GetDataSchedulerImpl implements GetDataScheduler {

    private EventPublisher eventPublisher;
    private WeatherApi weatherApi;

    @Autowired
    public GetDataSchedulerImpl(EventPublisher eventPublisher, @Qualifier(value = "yahoo") WeatherApi weatherApi) {
        this.eventPublisher = eventPublisher;
        this.weatherApi = weatherApi;
    }

    @Override
    @Scheduled(fixedDelay = 900000)
    public void getData() {
        log.info(getClass().getSimpleName() + " execution.");
        WeatherApiData weatherApiData = weatherApi.getNewestData();

        eventPublisher.publishEvent(new WeatherDataAppearedEvent(LocalDateTime.now(), weatherApiData));
    }

}
