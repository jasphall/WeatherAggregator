package com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.timeconverter

import com.github.fedy2.weather.data.unit.Time
import com.github.fedy2.weather.data.unit.TimeConvention
import spock.lang.Specification

import java.time.LocalTime

class TimeConventionConverterTest extends Specification {

    def "test convertion from date12Hour to date24Hour"() {
        given:
            TimeConventionConverter converter = new TimeConventionConverterImpl()

        when:
            LocalTime time = converter.convert12HourTo24HourFormat(new Time(date12Hour, date12Minute, date12Convention))

        then:
            time.hour == date24Hour
            time.minute == date24Minute

        where:
            date12Hour  |   date12Minute    |   date12Convention    |   date24Hour  |   date24Minute
            3           |   0               |   TimeConvention.AM   |   3           |   0
            0           |   0               |   TimeConvention.AM   |   0           |   0
            12          |   0               |   TimeConvention.AM   |   0           |   0
            11          |   49              |   TimeConvention.AM   |   11          |   49
            12          |   49              |   TimeConvention.PM   |   12          |   49
            1           |   49              |   TimeConvention.PM   |   13          |   49
    }

}