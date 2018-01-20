package com.nilportugues.messagebus.command;

import java.util.concurrent.CompletableFuture;

public interface ICommandHandler<C extends ICommand> {

    /**
     * Handles the command.
     *
     * @param command command to findActive
     * @return an CompletableFuture return value.
     */
    CompletableFuture handle(final C command);
}
