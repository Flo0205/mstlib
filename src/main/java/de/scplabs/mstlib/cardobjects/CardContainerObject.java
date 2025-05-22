package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for card container objects that can hold multiple child elements.
 *
 * @param <T>    the parent type
 * @param <SELF> the concrete type of the container (for fluent API)
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class CardContainerObject<T extends CardParent<?>, SELF extends CardContainerObject<T, SELF>> extends CardObject<T, SELF> {
    @JsonProperty(required = true)
    private List<Object> items = new ArrayList<>();
    public List<Object> getItems() {
        return items;
    }

    /**
     * Constructs a new CardContainerObject.
     *
     * @param parent the parent object
     * @param type   the type of the card object
     */
    protected CardContainerObject(T parent, String type) {
        super(parent, type);
    }

    /**
     * Adds a new ColumnSet to this container.
     *
     * @return the created ColumnSet
     */
    @SuppressWarnings("unchecked")
    public ColumnSet<SELF> addColumnSet() {
        ColumnSet<SELF> columnSet = new ColumnSet<>((SELF) this);
        items.add(columnSet);
        return columnSet;
    }

    /**
     * Adds a new Container to this container.
     *
     * @return the created Container
     */
    @SuppressWarnings("unchecked")
    public Container<SELF> addContainer() {
        Container<SELF> container = new Container<>((SELF) this);
        items.add(container);
        return container;
    }

    /**
     * Adds a new FactSet to this container.
     *
     * @return the created FactSet
     */
    @SuppressWarnings("unchecked")
    public FactSet<SELF> addFactSet() {
        FactSet<SELF> factSet = new FactSet<>((SELF) this);
        items.add(factSet);
        return factSet;
    }

    /**
     * Adds a new Image to this container.
     *
     * @param url the image URL
     * @return the created Image
     */
    @SuppressWarnings("unchecked")
    public Image<SELF> addImage(String url) {
        Image<SELF> im = new Image<>((SELF) this, url);
        items.add(im);
        return im;
    }

    /**
     * Adds a new ImageSet to this container.
     *
     * @return the created ImageSet
     */
    @SuppressWarnings("unchecked")
    public ImageSet<SELF> addImageSet() {
        ImageSet<SELF> imSet = new ImageSet<>((SELF) this);
        items.add(imSet);
        return imSet;
    }

    /**
     * Adds a new Table to this container.
     *
     * @return the created Table
     */
    @SuppressWarnings("unchecked")
    public Table<SELF> addTable() {
        Table<SELF> table = new Table<>((SELF) this);
        items.add(table);
        return table;
    }

    /**
     * Adds a new TextBlock to this container.
     *
     * @param text the text content
     * @return the created TextBlock
     */
    @SuppressWarnings("unchecked")
    public TextBlock<SELF> addTextBlock(String text) {
        TextBlock<SELF> tb = new TextBlock<>((SELF) this, text);
        items.add(tb);
        return tb;
    }

    /**
     * Adds a new Media element to this container.
     *
     * @return the created Media
     */
    @SuppressWarnings("unchecked")
    public Media<SELF> addMedia() {
        Media<SELF> media = new Media<>((SELF) this);
        items.add(media);
        return media;
    }

    /**
     * Adds a new RichTextBlock to this container.
     *
     * @return the created RichTextBlock
     */
    @SuppressWarnings("unchecked")
    public RichTextBlock<SELF> addRichTextBlock() {
        RichTextBlock<SELF> tb = new RichTextBlock<>((SELF) this);
        items.add(tb);
        return tb;
    }
}
