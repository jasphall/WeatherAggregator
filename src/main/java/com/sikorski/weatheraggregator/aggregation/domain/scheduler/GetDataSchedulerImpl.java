package com.sikorski.weatheraggregator.aggregation.domain.scheduler;

import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.events.WeatherDataAppearedEvent;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherApiProvider;
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
    private WeatherApiProvider weatherApiProvider;

    @Autowired
    public GetDataSchedulerImpl(EventPublisher eventPublisher, @Qualifier(value = "yahoo") WeatherApiProvider weatherApiProvider) {
        this.eventPublisher = eventPublisher;
        this.weatherApiProvider = weatherApiProvider;
    }

    @Override
    @Scheduled(fixedDelay = 900000)
    public void getData() {
        log.info(getClass().getSimpleName() + " execution.");
        WeatherApiData weatherApiData = weatherApiProvider.getNewestData();

        eventPublisher.publishEvent(new WeatherDataAppearedEvent(LocalDateTime.now(), weatherApiData));
    }

}
