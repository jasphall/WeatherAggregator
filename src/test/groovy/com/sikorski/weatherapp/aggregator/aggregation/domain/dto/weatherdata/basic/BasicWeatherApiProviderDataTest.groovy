package com.sikorski.weatherapp.aggregator.aggregation.domain.dto.weatherdata.basic

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.BasicWeatherApiData
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData
import spock.lang.Specification

class BasicWeatherApiProviderDataTest extends Specification {

    def "empty weather data object has no data"() {
        given: "empty weather data object"
            WeatherApiData weatherApiData = BasicWeatherApiData.empty()

        when: "check filled values size in object"
            int filledValuesSize = weatherApiData.filledValuesSize()

        then: "object should has no filled values and should be empty"
            weatherApiData.isEmpty()
            filledValuesSize == 0
    }

    def "filledValuesSize has correct result value when one parameter given"() {
        given: "weather data object with one parameter filled"
            WeatherApiData variant_1 = BasicWeatherApiDataTestBuilder.withOneParameter()

        when: "check filled values size in object"
            int filledValuesSize = variant_1.filledValuesSize()

        then: "object should not be empty and its filled values size should be 1"
            !variant_1.isEmpty()
            filledValuesSize == 1
    }

    def "filledValuesSize has correct result value when given two parameters"() {
        given: "weather data object with two parameters filled"
            WeatherApiData variant_2 = BasicWeatherApiDataTestBuilder.withTwoParameters()

        when: "check filled values size in object"
            int filledValuesSize = variant_2.filledValuesSize()

        then: "object should not be empty and its filled values size should be 2"
            !variant_2.isEmpty()
            filledValuesSize == 2
    }

    def "filledValuesSize has correct result value when given three parameters"() {
        given: "weather data object with three parameters filled"
            WeatherApiData variant_3 = BasicWeatherApiDataTestBuilder.withThreeParameters()

        when: "check filled values size in object"
            int filledValuesSize = variant_3.filledValuesSize()

        then: "object should not be empty and its filled values size should be 3"
            !variant_3.isEmpty()
            filledValuesSize == 3
    }

}
