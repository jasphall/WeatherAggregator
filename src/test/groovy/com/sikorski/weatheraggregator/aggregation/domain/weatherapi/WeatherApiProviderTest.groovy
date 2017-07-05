package com.sikorski.weatheraggregator.aggregation.domain.weatherapi

import com.sikorski.weatheraggregator.aggregation.domain.location.Location
import com.sikorski.weatheraggregator.aggregation.domain.location.LocationBuilder
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.mapper.WeatherApiMapper
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.YahooApiAccessor
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.YahooApiAccessorImpl
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.YahooWeatherApiMapper
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.YahooWeatherApiProvider
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.timeconverter.TimeConventionConverterImpl
import spock.lang.Specification

class WeatherApiProviderTest extends Specification {

    WeatherApiProvider weatherApiProvider

    def setup() {
        YahooApiAccessor yahooApiAccessor = new YahooApiAccessorImpl()
        WeatherApiMapper weatherApiMapper = new YahooWeatherApiMapper(new TimeConventionConverterImpl())

        weatherApiProvider = new YahooWeatherApiProvider(yahooApiAccessor, weatherApiMapper)
    }

    def "test if location in result data is correct"() {
        given:
        Location location = givenWeatherLocation()
        final String expectedLocation = "Warsaw"

        when:
        WeatherApiData weatherApiData = weatherApiProvider.getNewestData(location)

        then:
        weatherApiData.getLocationCity() == expectedLocation
    }

    private Location givenWeatherLocation() {
        return new LocationBuilder()
                .withCity("Warszawa")
                .build()
    }
}
