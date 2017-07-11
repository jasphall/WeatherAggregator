package com.sikorski.weatherapp.aggregator.application.events;

import java.time.LocalDateTime;

public interface Event {

    LocalDateTime when();

}
