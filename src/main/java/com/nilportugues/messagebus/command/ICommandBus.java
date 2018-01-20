package com.nilportugues.messagebus.command;

import com.nilportugues.messagebus.middlewares.IMiddleware;

import java.util.concurrent.CompletableFuture;

public interface ICommandBus {

    CompletableFuture<?> execute(final ICommand command);

    void addMiddleware(final IMiddleware middleware);
}
