package com.sikorski.weatheraggregator.domain.export.impl

import com.sikorski.weatheraggregator.domain.dataaggregation.commands.SaveWeatherCommand
import com.sikorski.weatheraggregator.domain.dataaggregation.commands.handlers.SaveWeatherHandler
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.basic.BasicWeatherApiData
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.exceptions.IncorrectWeatherDataException
import com.sikorski.weatheraggregator.domain.export.DataExporter
import com.sikorski.weatheraggregator.domain.export.ExportParameters
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CsvFileExporterTest extends Specification {

    DataExporter dataExporter
    SaveWeatherHandler handler

    void setup() {
        dataExporter = new CsvFileExporter()
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
            ExportParameters exportParameters = new ExportParameters(emptyMap)
            WeatherApiData weatherApiData = BasicWeatherApiData.empty()

        when:
            dataExporter.export(weatherApiData, exportParameters)

        then:
            Exception exception = thrown(RuntimeException)
            exception.message.contains("Parametr filename nie został dostarczony. Dane nie zostaną zapisane.")
    }

}
