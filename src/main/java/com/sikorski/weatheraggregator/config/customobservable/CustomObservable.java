package com.sikorski.weatheraggregator.config.customobservable;

import java.util.Observer;

/**
 * Interfejs ten pozwala na wyabstrahowanie obiektu Observable
 */
public interface CustomObservable {

    void addObserver(Observer o);
    void deleteObserver(Observer o);
    int countObservers();

}
