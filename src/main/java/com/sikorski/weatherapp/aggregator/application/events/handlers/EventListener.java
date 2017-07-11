package com.sikorski.weatherapp.aggregator.application.events.handlers;

import com.sikorski.weatherapp.aggregator.application.events.Event;

public interface EventListener<T extends Event> {

    @org.springframework.context.event.EventListener
    void handle(T event);

}
