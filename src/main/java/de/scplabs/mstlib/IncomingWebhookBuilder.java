package de.scplabs.mstlib;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.scplabs.mstlib.cardobjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Builder class for creating {@link IncomingWebhook} instances with adaptive card payloads.
 * Provides methods to add various card elements and construct the final webhook.
 */
public class IncomingWebhookBuilder implements CardParent<IncomingWebhookBuilder> {

    /** List holding the body elements of the adaptive card. */
    private final List<Object> body = new ArrayList<>();
    /** The target URL for the webhook. */
    private final String url;

    /**
     * Constructs a new {@code IncomingWebhookBuilder} with the specified URL.
     *
     * @param url the target URL for the webhook
     */
    public IncomingWebhookBuilder(String url) {
        this.url = url;
    }

    /**
     * Adds a new {@link ColumnSet} to the card body.
     *
     * @return the created {@code ColumnSet}
     */
    public ColumnSet<IncomingWebhookBuilder> addColumnSet() {
        ColumnSet<IncomingWebhookBuilder> columnSet = new ColumnSet<>(this);
        body.add(columnSet);
        return columnSet;
    }

    /**
     * Adds a new {@link Container} to the card body.
     *
     * @return the created {@code Container}
     */
    public Container<IncomingWebhookBuilder> addContainer() {
        Container<IncomingWebhookBuilder> container = new Container<>(this);
        body.add(container);
        return container;
    }

    /**
     * Adds a new {@link FactSet} to the card body.
     *
     * @return the created {@code FactSet}
     */
    public FactSet<IncomingWebhookBuilder> addFactSet() {
        FactSet<IncomingWebhookBuilder> factSet = new FactSet<>(this);
        body.add(factSet);
        return factSet;
    }

    /**
     * Adds a new {@link Image} to the card body.
     *
     * @param url the image URL
     * @return the created {@code Image}
     */
    public Image<IncomingWebhookBuilder> addImage(String url) {
        Image<IncomingWebhookBuilder> im = new Image<>(this, url);
        body.add(im);
        return im;
    }

    /**
     * Adds a new {@link ImageSet} to the card body.
     *
     * @return the created {@code ImageSet}
     */
    public ImageSet<IncomingWebhookBuilder> addImageSet() {
        ImageSet<IncomingWebhookBuilder> imSet = new ImageSet<>(this);
        body.add(imSet);
        return imSet;
    }

    /**
     * Adds a new {@link Table} to the card body.
     *
     * @return the created {@code Table}
     */
    public Table<IncomingWebhookBuilder> addTable() {
        Table<IncomingWebhookBuilder> table = new Table<>(this);
        body.add(table);
        return table;
    }

    /**
     * Adds a new {@link TextBlock} to the card body.
     *
     * @param text the text content
     * @return the created {@code TextBlock}
     */
    public TextBlock<IncomingWebhookBuilder> addTextBlock(String text) {
        TextBlock<IncomingWebhookBuilder> tb = new TextBlock<>(this, text);
        body.add(tb);
        return tb;
    }

    /**
     * Adds a new {@link Media} element to the card body.
     *
     * @return the created {@code Media}
     */
    public Media<IncomingWebhookBuilder> addMedia() {
        Media<IncomingWebhookBuilder> media = new Media<>(this);
        body.add(media);
        return media;
    }

    /**
     * Adds a new {@link RichTextBlock} to the card body.
     *
     * @return the created {@code RichTextBlock}
     */
    public RichTextBlock<IncomingWebhookBuilder> addRichTextBlock() {
        RichTextBlock<IncomingWebhookBuilder> tb = new RichTextBlock<>(this);
        body.add(tb);
        return tb;
    }

    /**
     * Builds the {@link IncomingWebhook} with the configured card elements and URL.
     *
     * @return the constructed {@code IncomingWebhook}, or {@code null} if JSON serialization fails
     */
    public IncomingWebhook build() {
        Map<String, Object> card = new HashMap<>();
        card.put("$schema", "http://adaptivecards.io/schemas/adaptive-card.json");
        card.put("type", "AdaptiveCard");
        card.put("version", "1.5");
        card.put("fallbackText", "Version 1.5 not supported by client");
        card.put("body", body);

        Map<String, Object> payload = new HashMap<>();
        payload.put("type", "message");
        payload.put("attachments", List.of(
                Map.of(
                        "contentType", "application/vnd.microsoft.card.adaptive",
                        "content", card
                )
        ));

        ObjectMapper mapper = new ObjectMapper();
        try {
            return new IncomingWebhook(url, mapper.writeValueAsString(payload));
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
