package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.timeconverter;

import com.github.fedy2.weather.data.unit.Time;

import java.time.LocalTime;

public interface TimeConventionConverter {

    LocalTime convert12HourTo24HourFormat(Time time);

}
