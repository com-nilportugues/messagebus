package com.nilportugues.messagebus.middlewares;

import java.util.concurrent.CompletableFuture;

public interface IMiddleware {
    CompletableFuture execute(final Object object);
}
