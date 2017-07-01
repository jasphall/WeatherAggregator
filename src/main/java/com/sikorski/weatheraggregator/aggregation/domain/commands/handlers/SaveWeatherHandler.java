package com.sikorski.weatheraggregator.aggregation.domain.commands.handlers;

import com.sikorski.weatheraggregator.aggregation.domain.commands.SaveWeatherCommand;
import com.sikorski.weatheraggregator.aggregation.domain.exceptions.IncorrectWeatherDataException;
import com.sikorski.weatheraggregator.application.cqrs.commands.handler.CommandHandler;
import com.sikorski.weatheraggregator.application.dto.NamedParameters;
import com.sikorski.weatheraggregator.persistence.DataPersistenceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SaveWeatherHandler implements CommandHandler<SaveWeatherCommand> {

    private final DataPersistenceProvider dataPersistenceProvider;

    @Autowired
    public SaveWeatherHandler(DataPersistenceProvider dataPersistenceProvider) {
        this.dataPersistenceProvider = dataPersistenceProvider;
    }

    @EventListener
    @Override
    public void handle(SaveWeatherCommand command) {
        if (command.getWeatherData() == null) {
            throw new IncorrectWeatherDataException();
        }
        dataPersistenceProvider.persist(command.getWeatherData(),
                NamedParameters.oneParameter("filename", command.getFilename()));

        log.info("{} handler.", command.getClass().getSimpleName());
    }

}
