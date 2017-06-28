package com.sikorski.weatheraggregator.domain.dataaggregation.commands.handlers;

import com.sikorski.weatheraggregator.application.cqrs.commands.handler.CommandHandler;
import com.sikorski.weatheraggregator.domain.dataaggregation.commands.SaveWeatherCommand;
import com.sikorski.weatheraggregator.domain.export.ExportParameters;
import com.sikorski.weatheraggregator.domain.export.impl.CsvFileExporter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SaveWeatherHandler implements CommandHandler<SaveWeatherCommand> {

    private final CsvFileExporter csvFileExporter;

    @Autowired
    public SaveWeatherHandler(CsvFileExporter csvFileExporter) {
        this.csvFileExporter = csvFileExporter;
    }

    @EventListener
    @Override
    public void handle(SaveWeatherCommand command) {
        csvFileExporter.export(command.getWeatherData(),
                ExportParameters.oneParameter("filename", command.getFilename()));

        log.info("{} handler.", command.getClass().getSimpleName());
    }

}
