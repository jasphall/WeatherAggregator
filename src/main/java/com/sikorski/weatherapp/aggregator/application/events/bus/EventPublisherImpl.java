package com.sikorski.weatherapp.aggregator.application.events.bus;

import com.sikorski.weatherapp.aggregator.application.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@Slf4j
public class EventPublisherImpl implements EventPublisher {

    @Inject
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishEvent(Event event) {
        applicationEventPublisher.publishEvent(event);
        log.info("{} has been published at {}.", event.getClass().getSimpleName(), event.when());
    }

}
