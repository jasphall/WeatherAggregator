package com.sikorski.weatherapp.aggregator.aggregation.domain.scheduler;

import com.sikorski.weatherapp.aggregator.aggregation.domain.events.WeatherDataAppearedEvent;
import com.sikorski.weatherapp.aggregator.aggregation.domain.location.Location;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.WeatherApiProvider;
import com.sikorski.weatherapp.aggregator.application.events.bus.EventPublisher;
import com.sikorski.weatherapp.aggregator.config.properties.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
class GetDataSchedulerImpl implements GetDataScheduler {

    private final EventPublisher eventPublisher;
    private final WeatherApiProvider weatherApiProvider;
    private final ApplicationProperties applicationProperties;

    @Autowired
    public GetDataSchedulerImpl(EventPublisher eventPublisher,
            @Qualifier(value = "yahoo") WeatherApiProvider weatherApiProvider,
            ApplicationProperties applicationProperties) {
        this.eventPublisher = eventPublisher;
        this.weatherApiProvider = weatherApiProvider;
        this.applicationProperties = applicationProperties;
    }

    @Override
    @Scheduled(fixedDelay = 900000)
    public void getData() {
        log.info(getClass().getSimpleName() + " execution.");
        Location location = Location.ofCity(applicationProperties.getLocation());
        WeatherApiData weatherApiData = weatherApiProvider.getNewestData(location);

        eventPublisher.publishEvent(new WeatherDataAppearedEvent(LocalDateTime.now(), weatherApiData));
    }

}
