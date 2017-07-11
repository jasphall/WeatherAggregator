package com.sikorski.weatherapp.aggregator.application.events.bus;

import com.sikorski.weatherapp.aggregator.application.events.Event;

public interface EventPublisher {

    void publishEvent(Event event);

}
