package com.sikorski.weatheraggregator.persistence

import com.sikorski.weatheraggregator.aggregation.domain.commands.SaveWeatherCommand
import com.sikorski.weatheraggregator.aggregation.domain.commands.handlers.SaveWeatherHandler
import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData
import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic.BasicWeatherApiData
import com.sikorski.weatheraggregator.aggregation.domain.exceptions.IncorrectWeatherDataException
import com.sikorski.weatheraggregator.application.dto.NamedParameters
import com.sikorski.weatheraggregator.utils.AppFileWriter
import groovy.mock.interceptor.MockFor
import spock.lang.Specification

class CsvFilePersistenceProviderTest extends Specification {

    DataPersistenceProvider dataExporter
    SaveWeatherHandler handler

    void setup() {
        dataExporter = new CsvFilePersistenceProvider()
        handler = new SaveWeatherHandler(dataExporter)
    }

    def "weatherData in command cannot be empty or null"() {
        given:
        SaveWeatherCommand nullDataCommand = new SaveWeatherCommand(null, "somefile")

        when:
        handler.handle(nullDataCommand)

        then:
        thrown(IncorrectWeatherDataException)
    }

    def "filename parameter should not be empty or null"() {
        given:
        SaveWeatherCommand command = new SaveWeatherCommand(BasicWeatherApiData.empty(), null)

        when:
        handler.handle(command)

        then:
        Exception exception = thrown(RuntimeException)
        exception.message.contains("Parametr filename nie został dostarczony. Dane nie zostaną zapisane.")
    }

    def "exportparameter map cannot be empty"() {
        given:
        Map emptyMap = Collections.emptyMap()
        NamedParameters exportParameters = new NamedParameters(emptyMap)
        WeatherApiData weatherApiData = BasicWeatherApiData.empty()

        when:
        dataExporter.persist(weatherApiData, exportParameters)

        then:
        Exception exception = thrown(RuntimeException)
        exception.message.contains("Parametr filename nie został dostarczony. Dane nie zostaną zapisane.")
    }

    def "headers should be append with end of the line char"() {
        given:
        String headers = dataExporter.headers(BasicWeatherApiData.empty())
        AppFileWriter fileWriter = Mock(AppFileWriter)

        when:
        String savedLine = dataExporter.saveLineToFile(headers, fileWriter)

        then:
        savedLine.endsWith("\n")
    }

}
