package com.sikorski.weatheraggregator.application.events.bus;

import com.sikorski.weatheraggregator.application.events.Event;

public interface EventPublisher {

    void publishEvent(Event event);

}
