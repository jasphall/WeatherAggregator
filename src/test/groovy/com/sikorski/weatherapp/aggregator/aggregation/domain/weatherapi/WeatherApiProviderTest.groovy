package com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi

import com.sikorski.weatherapp.aggregator.aggregation.domain.location.Location
import com.sikorski.weatherapp.aggregator.aggregation.domain.location.LocationBuilder
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.mapper.WeatherApiMapper
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.YahooApiAccessor
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.YahooApiAccessorImpl
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.YahooWeatherApiMapper
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.YahooWeatherApiProvider
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.timeconverter.TimeConventionConverterImpl
import spock.lang.Shared
import spock.lang.Specification

class WeatherApiProviderTest extends Specification {

    @Shared
    WeatherApiProvider weatherApiProvider

    def setupSpec() {
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
