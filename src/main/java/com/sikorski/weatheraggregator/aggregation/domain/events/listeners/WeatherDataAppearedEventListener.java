package com.sikorski.weatheraggregator.aggregation.domain.events.listeners;

import com.sikorski.weatheraggregator.aggregation.domain.commands.SaveWeatherCommand;
import com.sikorski.weatheraggregator.aggregation.domain.events.WeatherDataAppearedEvent;
import com.sikorski.weatheraggregator.application.cqrs.commands.bus.CommandBus;
import com.sikorski.weatheraggregator.application.events.handlers.EventListener;
import com.sikorski.weatheraggregator.config.properties.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class WeatherDataAppearedEventListener implements EventListener<WeatherDataAppearedEvent> {

    private CommandBus commandBus;
    private ConfigurationProperties configurationProperties;

    @Autowired
    public WeatherDataAppearedEventListener(CommandBus commandBus, ConfigurationProperties configurationProperties) {
        this.commandBus = commandBus;
        this.configurationProperties = configurationProperties;
    }

    @Override
    public void handle(WeatherDataAppearedEvent event) {
        commandBus.publishCommand(new SaveWeatherCommand(event.getWeatherData()));
    }
}
