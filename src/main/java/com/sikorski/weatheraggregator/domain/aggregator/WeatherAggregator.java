package com.sikorski.weatheraggregator.domain.aggregator;

import com.sikorski.weatheraggregator.config.Loggable;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import org.springframework.stereotype.Component;

import java.util.Observable;

@Component
public class WeatherAggregator extends Observable implements Loggable {

    public void onData(WeatherApiData weatherApiData) {
        setChanged();
        notifyObservers(weatherApiData);
    }

}
