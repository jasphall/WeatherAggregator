package com.sikorski.weatheraggregator.config.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Loggable {

    default Logger logger() {
        return LoggerFactory.getLogger(getClass());
    }

}
