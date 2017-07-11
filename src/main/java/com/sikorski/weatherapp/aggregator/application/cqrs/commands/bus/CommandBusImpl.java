package com.sikorski.weatherapp.aggregator.application.cqrs.commands.bus;

import com.sikorski.weatherapp.aggregator.application.cqrs.commands.Command;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CommandBusImpl implements CommandBus {

    @Inject
    private ApplicationEventPublisher publisher;

    @Override
    public void publishCommand(Command command) {
        publisher.publishEvent(command);
    }

}
