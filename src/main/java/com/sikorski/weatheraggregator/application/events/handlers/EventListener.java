package com.sikorski.weatheraggregator.application.events.handlers;

import com.sikorski.weatheraggregator.application.events.Event;

public interface EventListener<T extends Event> {

    @org.springframework.context.event.EventListener
    void handle(T event);

}
