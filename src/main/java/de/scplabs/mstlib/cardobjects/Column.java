package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.scplabs.mstlib.options.BackGroundImage;
import de.scplabs.mstlib.options.ContainerStyle;
import de.scplabs.mstlib.options.VerticalContentAlignment;

/**
 * Represents a column element in an adaptive card, which can contain multiple child elements and various layout options.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Column<T extends CardParent<?>> extends CardContainerObject<T, Column<T>> {

    private BackGroundImage<Column<T>> backgroundImage;
    private boolean bleed = false;
    private String minHeight = "";
    private boolean rtl = false;
    private ContainerStyle style = ContainerStyle.DEFAULT;
    private VerticalContentAlignment verticalContentAlignment = VerticalContentAlignment.TOP;
    private String width = "";

    public BackGroundImage<Column<T>> getBackgroundImage() { return backgroundImage; }
    public boolean isBleed() { return bleed; }
    public String getMinHeight() { return minHeight; }
    public boolean isRtl() { return rtl; }
    public String getStyle() { return style.toString(); }
    public String getVerticalContentAlignment() { return verticalContentAlignment.toString(); }
    public String getWidth() { return width; }

    /**
     * Protected default constructor for serialization.
     */
    protected Column() {
        super(null, null);
    }

    /**
     * Constructs a new Column with the specified parent.
     *
     * @param parent the parent object
     */
    protected Column(T parent) {
        super(parent, "Column");
    }

    /**
     * Adds a background image to this column.
     *
     * @param url the URL of the background image
     * @return the created BackGroundImage object
     */
    public BackGroundImage<Column<T>> addBackgroundImage(String url) {
        this.backgroundImage = new BackGroundImage<>(this, url);
        return backgroundImage;
    }

    /**
     * Sets whether the column should bleed outside its parent padding.
     *
     * @param bleed true to enable bleed, false otherwise
     * @return this column for method chaining
     */
    public Column<T> setBleed(boolean bleed) {
        this.bleed = bleed;
        return this;
    }

    /**
     * Sets the minimum height of the column.
     *
     * @param minHeight the minimum height as a string
     * @return this column for method chaining
     */
    public Column<T> setMinHeight(String minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    /**
     * Sets whether the content should be displayed right-to-left.
     *
     * @param rtl true to enable RTL, false otherwise
     * @return this column for method chaining
     */
    public Column<T> setRtl(boolean rtl) {
        this.rtl = rtl;
        return this;
    }

    /**
     * Sets the style of the column.
     *
     * @param style the container style
     * @return this column for method chaining
     */
    public Column<T> setStyle(ContainerStyle style) {
        this.style = style;
        return this;
    }

    /**
     * Sets the vertical content alignment of the column.
     *
     * @param verticalContentAlignment the vertical content alignment
     * @return this column for method chaining
     */
    public Column<T> setVerticalContentAlignment(VerticalContentAlignment verticalContentAlignment) {
        this.verticalContentAlignment = verticalContentAlignment;
        return this;
    }

    /**
     * Sets the width of the column.
     *
     * @param width the width as a string
     * @return this column for method chaining
     */
    public Column<T> setWidth(String width) {
        this.width = width;
        return this;
    }
}
