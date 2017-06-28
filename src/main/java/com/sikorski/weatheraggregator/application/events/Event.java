package com.sikorski.weatheraggregator.application.events;

import java.time.LocalDateTime;

public interface Event {

    LocalDateTime when();

}
