package com.sikorski.weatheraggregator.qualityscoring.domain

import com.sikorski.weatheraggregator.aggregation.domain.model.dto.BasicWeatherApiData
import spock.lang.Specification

class DataQualityScoringTest extends Specification {

    def "quality correct when configured data given"() {
        given:
            DataQualityScoring qualityScoring = new SimpleDataQualityScoring()

        when:
            double calculatedScore = qualityScoring.score(data)

        then:
            calculatedScore == score

        where:
            score   |   data
            0       |   BasicWeatherApiData.empty()
    }

}
