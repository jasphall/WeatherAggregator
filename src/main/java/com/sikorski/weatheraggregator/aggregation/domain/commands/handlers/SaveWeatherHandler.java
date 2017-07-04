package com.sikorski.weatheraggregator.aggregation.domain.commands.handlers;

import com.sikorski.weatheraggregator.aggregation.domain.commands.SaveWeatherCommand;
import com.sikorski.weatheraggregator.aggregation.domain.exceptions.IncorrectWeatherDataException;
import com.sikorski.weatheraggregator.aggregation.domain.persistence.DataPersistenceProvider;
import com.sikorski.weatheraggregator.application.cqrs.commands.handler.CommandHandler;
import com.sikorski.weatheraggregator.application.dto.NamedParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SaveWeatherHandler implements CommandHandler<SaveWeatherCommand> {

    private final DataPersistenceProvider dataPersistenceProvider;

    @Autowired
    public SaveWeatherHandler(@Qualifier("dbPersistenceProvider") DataPersistenceProvider dataPersistenceProvider) {
        this.dataPersistenceProvider = dataPersistenceProvider;
    }

    @EventListener
    @Override
    public void handle(SaveWeatherCommand command) {
        log.info("{} handler.", command.getClass().getSimpleName());

        if (command.getWeatherData() == null) {
            throw new IncorrectWeatherDataException();
        }

        dataPersistenceProvider.persist(command.getWeatherData(), NamedParameters.empty());
    }

}
