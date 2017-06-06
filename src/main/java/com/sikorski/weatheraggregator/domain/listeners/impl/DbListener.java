package com.sikorski.weatheraggregator.domain.listeners.impl;

import com.sikorski.weatheraggregator.domain.aggregator.WeatherAggregator;
import com.sikorski.weatheraggregator.domain.listeners.WeatherChangeObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Observable;

@Component
public class DbListener implements WeatherChangeObserver {

    private final WeatherAggregator weatherAggregator;

    @Autowired
    public DbListener(WeatherAggregator weatherAggregator) {
        this.weatherAggregator = weatherAggregator;
        init();
    }

    @Override
    public void init() {
        weatherAggregator.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        logger().info(getClass().getSimpleName() + " updated.");
    }
}
