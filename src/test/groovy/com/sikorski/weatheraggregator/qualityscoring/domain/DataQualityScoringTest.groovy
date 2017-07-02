package com.sikorski.weatheraggregator.qualityscoring.domain

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic.BasicWeatherApiData
import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic.BasicWeatherApiDataTestBuilder
import spock.lang.Specification

class DataQualityScoringTest extends Specification {

    def "quality equals #score when configured #data given"() {
        given:
        DataQualityScoring qualityScoring = new SimpleDataQualityScoring()

        when:
        double calculatedScore = qualityScoring.score(data)

        then:
        calculatedScore == score

        where:
        score   |   data
        0       |   BasicWeatherApiData.empty()
        0.25    |   BasicWeatherApiDataTestBuilder.withOneParameter()
        0.5     |   BasicWeatherApiDataTestBuilder.withTwoParameters()
        0.75    |   BasicWeatherApiDataTestBuilder.withThreeParameters()
    }

}
