package de.scplabs.mstlib;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * The {@code Webhook} interface defines methods for executing a webhook
 * that sends an HTTP request and receives a response, both synchronously and asynchronously.
 */
public interface Webhook {
    /**
     * Executes the webhook synchronously and returns the HTTP response.
     *
     * @return the HTTP response as {@code HttpResponse<String>}
     * @throws InterruptedException if the execution thread is interrupted
     */
    HttpResponse<String> execute() throws InterruptedException;

    /**
     * Executes the webhook asynchronously and returns a {@code CompletableFuture}
     * containing the HTTP response.
     *
     * @return a {@code CompletableFuture} with the HTTP response as {@code HttpResponse<String>}
     */
    CompletableFuture<HttpResponse<String>> executeAsync();
}
