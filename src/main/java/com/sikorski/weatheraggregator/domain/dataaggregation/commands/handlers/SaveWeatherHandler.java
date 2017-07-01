package com.sikorski.weatheraggregator.domain.dataaggregation.commands.handlers;

import com.sikorski.weatheraggregator.application.cqrs.commands.handler.CommandHandler;
import com.sikorski.weatheraggregator.domain.dataaggregation.commands.SaveWeatherCommand;
import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.exceptions.IncorrectWeatherDataException;
import com.sikorski.weatheraggregator.domain.export.DataExporter;
import com.sikorski.weatheraggregator.domain.export.ExportParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SaveWeatherHandler implements CommandHandler<SaveWeatherCommand> {

    private final DataExporter dataExporter;

    @Autowired
    public SaveWeatherHandler(DataExporter dataExporter) {
        this.dataExporter = dataExporter;
    }

    @EventListener
    @Override
    public void handle(SaveWeatherCommand command) {
        if (command.getWeatherData() == null) {
            throw new IncorrectWeatherDataException();
        }
        dataExporter.export(command.getWeatherData(),
                ExportParameters.oneParameter("filename", command.getFilename()));

        log.info("{} handler.", command.getClass().getSimpleName());
    }

}
