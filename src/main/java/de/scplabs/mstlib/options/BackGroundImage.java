package de.scplabs.mstlib.options;

import de.scplabs.mstlib.cardobjects.CardParent;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents a background image option for a card object.
 *
 * @param <T> the type of the parent card object
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BackGroundImage<T extends CardParent<?>> implements CardParent<T> {
    /**
     * The parent card object.
     */
    protected T parent;

    /**
     * Returns the parent card object.
     *
     * @return the parent card object
     */
    public T prev() { return parent; }

    private String url;
    private ImageFillMode fillMode;
    private HorizontalAlignments horizontalAlignment = HorizontalAlignments.LEFT;
    private VerticalContentAlignment verticalAlignment = VerticalContentAlignment.TOP;

    public String getUrl() { return url; }
    public ImageFillMode getFillMode() { return fillMode; }
    public HorizontalAlignments getHorizontalAlignment() { return horizontalAlignment; }
    public VerticalContentAlignment getVerticalAlignment() { return verticalAlignment; }

    /**
     * Protected default constructor for jackson serialization.
     */
    protected BackGroundImage() {
        super();
    }

    /**
     * Constructs a BackGroundImage with the specified parent and image URL.
     *
     * @param parent the parent card object
     * @param url the image URL
     */
    public BackGroundImage(T parent, String url) {
        this.parent = parent;
        this.url = url;
    }

    /**
     * Sets the fill mode for the background image.
     *
     * @param fillMode the image fill mode
     * @return this BackGroundImage instance
     */
    public BackGroundImage<T> setFillMode(ImageFillMode fillMode) {
        this.fillMode = fillMode;
        return this;
    }

    /**
     * Sets the horizontal alignment for the background image.
     *
     * @param horizontalAlignment the horizontal alignment
     * @return this BackGroundImage instance
     */
    public BackGroundImage<T> setHorizontalAlignment(HorizontalAlignments horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
        return this;
    }

    /**
     * Sets the vertical alignment for the background image.
     *
     * @param verticalAlignment the vertical alignment
     * @return this BackGroundImage instance
     */
    public BackGroundImage<T> setVerticalAlignment(VerticalContentAlignment verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
        return this;
    }
}