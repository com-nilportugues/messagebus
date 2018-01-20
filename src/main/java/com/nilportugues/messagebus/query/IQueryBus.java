package com.nilportugues.messagebus.query;

import com.nilportugues.messagebus.middlewares.IMiddleware;

import java.util.concurrent.CompletableFuture;

public interface IQueryBus {

    CompletableFuture<?> dispatch(final IQuery query);

    void addMiddleware(final IMiddleware middleware);
}
