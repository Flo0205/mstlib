package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.scplabs.mstlib.options.BackGroundImage;
import de.scplabs.mstlib.options.ContainerStyle;
import de.scplabs.mstlib.options.VerticalContentAlignment;

/**
 * Represents a container element in an adaptive card, which can hold multiple child elements
 * and supports various layout and style options.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Container<T extends CardParent<?>> extends CardContainerObject<T, Container<T>> {

    private ContainerStyle style = ContainerStyle.DEFAULT;
    private VerticalContentAlignment verticalContentAlignment = VerticalContentAlignment.TOP;
    private boolean bleed = false;
    private BackGroundImage<Container<T>> backgroundImage = null;
    private String minHeight = "";
    @JsonProperty("rtl?")
    private boolean rtl = false;

    public ContainerStyle getStyle() { return style; }
    public VerticalContentAlignment getVerticalContentAlignment() { return verticalContentAlignment; }
    public boolean isBleed() { return bleed; }
    public BackGroundImage<Container<T>> getBackgroundImage() { return backgroundImage; }
    public String getMinHeight() { return minHeight; }
    public boolean isRtl() { return rtl; }

    /**
     * Protected default constructor for serialization.
     */
    protected Container() {
        super(null, null);
    }

    /**
     * Constructs a new Container with the specified parent.
     *
     * @param parent the parent object
     */
    public Container(T parent) {
        super(parent, "Container");
    }

    /**
     * Sets the style of the container.
     *
     * @param style the container style
     * @return this container for method chaining
     */
    public Container<T> setStyle(ContainerStyle style) {
        this.style = style;
        return this;
    }

    /**
     * Sets the vertical content alignment of the container.
     *
     * @param verticalContentAlignment the vertical content alignment
     * @return this container for method chaining
     */
    public Container<T> setVerticalContentAlignment(VerticalContentAlignment verticalContentAlignment) {
        this.verticalContentAlignment = verticalContentAlignment;
        return this;
    }

    /**
     * Sets whether the container should bleed outside its parent padding.
     *
     * @param bleed true to enable bleed, false otherwise
     * @return this container for method chaining
     */
    public Container<T> setBleed(boolean bleed) {
        this.bleed = bleed;
        return this;
    }

    /**
     * Adds a background image to this container.
     *
     * @param url the URL of the background image
     * @return the created BackGroundImage object
     */
    public BackGroundImage<Container<T>> addBackgroundImage(String url) {
        this.backgroundImage = new BackGroundImage<>(this, url);
        return this.backgroundImage;
    }

    /**
     * Sets the minimum height of the container.
     *
     * @param minHeight the minimum height (e.g., "100px")
     * @return this container for method chaining
     */
    public Container<T> setMinHeight(String minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    /**
     * Sets whether the container should be displayed in right-to-left (RTL) mode.
     *
     * @param rtl true to enable RTL, false otherwise
     * @return this container for method chaining
     */
    public Container<T> setRtl(boolean rtl) {
        this.rtl = rtl;
        return this;
    }
}
