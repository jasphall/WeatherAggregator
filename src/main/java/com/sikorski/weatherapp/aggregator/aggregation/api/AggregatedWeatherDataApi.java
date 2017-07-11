package com.sikorski.weatherapp.aggregator.aggregation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class AggregatedWeatherDataApi {

    private final AggregatedWeatherDataService aggregatedWeatherDataService;

    @Autowired
    public AggregatedWeatherDataApi(AggregatedWeatherDataService aggregatedWeatherDataService) {
        this.aggregatedWeatherDataService = aggregatedWeatherDataService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AggregatedWeatherData> getWeatherDataInTimeRange(
        @RequestParam("startDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm") Date startDateTime,
        @RequestParam("endDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm") Date endDateTime) {

        return aggregatedWeatherDataService.getWeatherDataInTimeRange(startDateTime, endDateTime);
    }

}
