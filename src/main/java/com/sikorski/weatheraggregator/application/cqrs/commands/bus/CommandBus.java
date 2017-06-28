package com.sikorski.weatheraggregator.application.cqrs.commands.bus;

import com.sikorski.weatheraggregator.application.cqrs.commands.Command;

public interface CommandBus {

    void publishCommand(Command command);

}
