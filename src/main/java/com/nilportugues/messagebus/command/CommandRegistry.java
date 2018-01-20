package com.nilportugues.messagebus.command;

import com.nilportugues.messagebus.di.IBeanProvider;
import com.nilportugues.messagebus.resolvers.ResolverStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CommandRegistry {

    private static final Logger log = LoggerFactory.getLogger(CommandRegistry.class);
    private static final String LOG_LINE = "[Query Bus][Registered] {}";

    private final Map<String, String> commands;
    private final ResolverStrategy resolver;
    private final IBeanProvider provider;

    public CommandRegistry(final IBeanProvider provider, final ResolverStrategy resolver) {
        this.commands = new HashMap<>();
        this.provider = provider;
        this.resolver = resolver;
    }

    public void register(final Class<? extends ICommand> command, final ICommandHandler handler) {
        CompletableFuture.runAsync(() -> {
            final String commandName = resolver.get(command);
            final String handlerBeanName = resolver.get(handler);

            registerHandler(handlerBeanName, commandName);
            logRegistration(commandName);
        });
    }

    public void register(final Class<? extends ICommand> command, final String handlerBeanName) {
        CompletableFuture.runAsync(() -> {
            final String commandName = resolver.get(command);

            registerHandler(handlerBeanName, commandName);
            logRegistration(commandName);
        });
    }

    private void registerHandler(final String handlerBeanName, final String commandName) {
        commands.put(commandName, handlerBeanName);
    }

    private void logRegistration(final String commandName) {
        log.debug(LOG_LINE, commandName);
    }

    public ICommandHandler get(final ICommand command) {
        final String commandClassName = resolver.get(command);
        final String commandHandlerClassName = commands.get(commandClassName);

        return (ICommandHandler) provider.get(commandHandlerClassName);
    }
}
