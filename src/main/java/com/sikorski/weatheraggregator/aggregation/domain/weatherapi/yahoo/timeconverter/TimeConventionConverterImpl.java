package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.timeconverter;

import com.github.fedy2.weather.data.unit.Time;
import com.github.fedy2.weather.data.unit.TimeConvention;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
class TimeConventionConverterImpl implements TimeConventionConverter {

    @Override
    public LocalTime convert12HourTo24HourFormat(Time time) {
        int resultHour = 0;
        TimeConvention convention = time.getConvention();
        int hours = time.getHours();

        if (convention == TimeConvention.AM) {
            resultHour = adjustAMConvention(hours);
        } else if (convention == TimeConvention.PM) {
            resultHour = adjustPMConvention(hours);
        }

        return LocalTime.of(resultHour, time.getMinutes());
    }

    private int adjustPMConvention(int hours) {
        if (hours == 12) {
            return hours;
        } else {
            return hours + 12;
        }
    }

    private int adjustAMConvention(int hours) {
        if (hours == 12) {
            return hours - 12;
        } else {
            return hours;
        }
    }

}
