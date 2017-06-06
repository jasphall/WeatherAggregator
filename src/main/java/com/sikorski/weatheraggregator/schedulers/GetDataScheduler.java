package com.sikorski.weatheraggregator.schedulers;

import com.sikorski.weatheraggregator.config.Loggable;

public interface GetDataScheduler extends Loggable {

    void getData();

}
