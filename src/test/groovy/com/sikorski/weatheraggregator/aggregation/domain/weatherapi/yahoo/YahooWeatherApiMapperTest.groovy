package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo

import com.github.fedy2.weather.data.Atmosphere
import com.github.fedy2.weather.data.Channel
import com.github.fedy2.weather.data.Condition
import com.github.fedy2.weather.data.Item
import com.github.fedy2.weather.data.unit.Time
import com.github.fedy2.weather.data.unit.TimeConvention
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.mapper.WeatherApiMapper
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.timeconverter.TimeConventionConverter
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.timeconverter.TimeConventionConverterImpl
import spock.lang.Specification

import java.time.LocalTime
import java.time.ZoneId

class YahooWeatherApiMapperTest extends Specification {

    TimeConventionConverter timeConventionConverter
    WeatherApiMapper yahooWeatherApiMapper

    def setup() {
        timeConventionConverter = new TimeConventionConverterImpl()
        yahooWeatherApiMapper = new YahooWeatherApiMapper(timeConventionConverter)
    }

    def "test empty channel will be mapped to correct empty dto"() {
        given:
        Channel channel = null

        when:
        WeatherApiData weatherApiData = yahooWeatherApiMapper.map(channel)

        then:
        weatherApiData != null
        weatherApiData.isEmpty()
    }

    def "test date is correctly parsed when timeConvention is AM"() {
        given:
        Date date = new Date()
        Time time = new Time(3, 30, TimeConvention.AM)

        when:
        Date resultDate = yahooWeatherApiMapper.mapSunTime(date, time)

        then:
        LocalTime localTime = resultDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime()
        localTime.hour == 3 && localTime.minute == 30
    }

    def "test date is correctly parsed when timeConvention is PM"() {
        given:
        Date date = new Date()
        Time time = new Time(3, 30, TimeConvention.PM)

        when:
        Date resultDate = yahooWeatherApiMapper.mapSunTime(date, time)

        then:
        LocalTime localTime = resultDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime()
        localTime.hour == 15 && localTime.minute == 30
    }

    def "test filled channel will be mapped to correct dto"() {
        given:
        Channel channel = givenChannel()

        when:
        WeatherApiData weatherApiData = yahooWeatherApiMapper.map(channel)

        then:
        weatherApiData.filledValuesSize() == 2
    }

    def givenChannel() {
        Channel channel = new Channel()

        channel.lastBuildDate = new Date()
        channel.item = givenItem()
        channel.atmosphere = givenAtmosphere()

        return channel
    }

    def givenItem() {
        Item item = new Item()
        item.condition = new Condition()
        item.condition.temp = 25

        return item
    }

    def givenAtmosphere() {
        Atmosphere atmosphere = new Atmosphere()
        atmosphere.pressure = 1000

        return atmosphere
    }
}
