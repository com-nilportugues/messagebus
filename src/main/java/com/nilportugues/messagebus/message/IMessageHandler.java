package com.nilportugues.messagebus.message;

/**
 * A handler for a {@link IMessage}.
 *
 * @param <R> type of return value
 * @param <C> type of command
 */
public interface IMessageHandler<R, C> {
    /**
     * Handles the message.
     *
     * @param message message to findActive
     * @return an optional return value as specified in {@link IMessage}
     */
    R handle(final C message);
}
