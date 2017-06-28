package com.sikorski.weatheraggregator.domain.dataaggregation.events.listeners;

import com.sikorski.weatheraggregator.application.events.handlers.EventListener;
import com.sikorski.weatheraggregator.config.properties.ConfigurationProperties;
import com.sikorski.weatheraggregator.application.cqrs.commands.bus.CommandBus;
import com.sikorski.weatheraggregator.domain.dataaggregation.commands.SaveWeatherCommand;
import com.sikorski.weatheraggregator.domain.dataaggregation.events.WeatherDataAppearedEvent;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class WeatherDataAppearedEventListener implements EventListener<WeatherDataAppearedEvent> {

    private CommandBus commandBus;
    private ConfigurationProperties configurationProperties;

    @Inject
    public WeatherDataAppearedEventListener(CommandBus commandBus, ConfigurationProperties configurationProperties) {
        this.commandBus = commandBus;
        this.configurationProperties = configurationProperties;
    }

    @Override
    public void handle(WeatherDataAppearedEvent event) {
        String filename = configurationProperties.getCsvExportFilename();
        commandBus.publishCommand(new SaveWeatherCommand(event.getWeatherData(), filename));
    }
}
