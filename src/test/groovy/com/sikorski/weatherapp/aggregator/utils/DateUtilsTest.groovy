package com.sikorski.weatherapp.aggregator.utils

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class DateUtilsTest extends Specification {

    @Unroll
    def "test convertion from #localDateTime should give #result"() {
        when:
            Date date = DateUtils.asDate(localDateTime)

        then:
            date.format(DateUtils.standardDateTimePattern) == result

        where:
            localDateTime                                                                       |   result
            LocalDateTime.of(LocalDate.of(2017, 1, 1), LocalTime.of(0, 0))        |   "2017-01-01 00:00"
            LocalDateTime.of(LocalDate.of(2017, 5, 2), LocalTime.of(11, 10))      |   "2017-05-02 11:10"
            LocalDateTime.of(LocalDate.of(2000, 11, 21), LocalTime.of(15, 33))    |   "2000-11-21 15:33"
    }

    @Unroll
    def "test convertion from #pattern should give #result"() {
        when:
            Date date = DateUtils.fromPattern(pattern)

        then:
            date.format(DateUtils.standardDateTimePattern) == result

        where:
            pattern             |   result
            "2017-01-01 00:00"  |   "2017-01-01 00:00"
            "2017-05-02 11:10"  |   "2017-05-02 11:10"
            "2000-11-21 15:33"  |   "2000-11-21 15:33"
    }

}
