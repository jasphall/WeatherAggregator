package com.sikorski.weatheraggregator.domain.api;

import com.sikorski.weatheraggregator.config.Loggable;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;

public interface WeatherApi extends Loggable {

    WeatherApiData getNewestData();

}
