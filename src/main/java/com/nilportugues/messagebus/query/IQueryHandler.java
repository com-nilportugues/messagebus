package com.nilportugues.messagebus.query;

import java.util.concurrent.CompletableFuture;

public interface IQueryHandler<Q extends IQuery> {

    CompletableFuture handle(final Q query);
}
