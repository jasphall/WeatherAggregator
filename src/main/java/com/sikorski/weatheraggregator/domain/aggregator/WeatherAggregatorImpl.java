package com.sikorski.weatheraggregator.domain.aggregator;

import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

@Component
public class WeatherAggregatorImpl extends Observable implements WeatherAggregator {

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        logger().info("Zarejestrowano nowego obserwatora: {}.", o.getClass().getSimpleName());
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
        logger().info("Usunięto z listy obserwatorów: {}.", o.getClass().getSimpleName());
    }

    @Override
    public void onData(WeatherApiData weatherApiData) {
        setChanged();
        notifyObservers(weatherApiData);
    }

}
