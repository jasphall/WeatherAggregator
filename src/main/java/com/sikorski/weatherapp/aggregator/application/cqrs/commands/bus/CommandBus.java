package com.sikorski.weatherapp.aggregator.application.cqrs.commands.bus;

import com.sikorski.weatherapp.aggregator.application.cqrs.commands.Command;

public interface CommandBus {

    void publishCommand(Command command);

}
