package com.sikorski.weatheraggregator.application.events.bus;

import com.sikorski.weatheraggregator.application.events.Event;
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
