package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData
import spock.lang.Specification

class BasicWeatherApiProviderDataTest extends Specification {

    def "empty object has no data"() {
        given:
        WeatherApiData weatherApiData = BasicWeatherApiData.empty()

        when:
        int filledValuesSize = weatherApiData.filledValuesSize()

        then:
        weatherApiData.isEmpty()
        filledValuesSize == 0
    }

    def "filledValuesSize has correct result value when given one parameter"() {
        given:
        WeatherApiData variant_1 = BasicWeatherApiDataTestBuilder.withOneParameter()

        when:
        int filledValuesSize = variant_1.filledValuesSize()

        then:
        !variant_1.isEmpty()
        filledValuesSize == 1
    }

    def "filledValuesSize has correct result value when given two parameters"() {
        given:
        WeatherApiData variant_2 = BasicWeatherApiDataTestBuilder.withTwoParameters()

        when:
        int filledValuesSize = variant_2.filledValuesSize()

        then:
        !variant_2.isEmpty()
        filledValuesSize == 2
    }

    def "filledValuesSize has correct result value when given three parameters"() {
        given:
        WeatherApiData variant_3 = BasicWeatherApiDataTestBuilder.withThreeParameters()

        when:
        int filledValuesSize = variant_3.filledValuesSize()

        then:
        !variant_3.isEmpty()
        filledValuesSize == 3
    }

}
