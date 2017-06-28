package com.sikorski.weatheraggregator.application.cqrs.commands.handler;

/**
 * Handler dla komend CQRS
 */
public interface CommandHandler<C> {

    /**
     * Obsługa komendy
     *
     * @param command
     * @return
     */
    void handle(C command);

}
