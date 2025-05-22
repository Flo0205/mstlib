package de.scplabs.mstlib;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * The {@code IncomingWebhook} class implements the {@link Webhook} interface
 * and allows sending HTTP POST requests with a JSON payload to a specified URL,
 * both synchronously and asynchronously.
 */
public class IncomingWebhook implements Webhook {

    private final String url;
    private final String payload;

    /**
     * Creates a new instance of {@code IncomingWebhook} with the specified URL and payload.
     *
     * Use {@link IncomingWebhookBuilder} to create an instance of this class.
     *
     * @param url     the target URL for the webhook
     * @param payload the JSON payload to send
     */
    protected IncomingWebhook(String url, String payload) {
        this.url = url;
        this.payload = payload;
    }

    @Override
    public HttpResponse<String> execute() throws InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompletableFuture<HttpResponse<String>> executeAsync() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();
            return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
