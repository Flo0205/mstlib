package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.scplabs.mstlib.options.BackGroundImage;
import de.scplabs.mstlib.options.ContainerStyle;
import de.scplabs.mstlib.options.VerticalContentAlignment;

/**
 * Represents a cell within a table in an adaptive card, supporting various style and layout options
 * such as background image, vertical alignment, minimum height, and right-to-left text direction.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TableCell<T extends CardParent<?>> extends CardContainerObject<T, TableCell<T>> {

    private ContainerStyle style = ContainerStyle.DEFAULT;
    private VerticalContentAlignment verticalAlignment = VerticalContentAlignment.TOP;
    private boolean bleed = false;
    private BackGroundImage<TableCell<T>> backgroundImage;
    private String minHeight = "";
    @JsonProperty("rtl?")
    private boolean rtl = false;

    public String getStyle() { return style.toString(); }
    public String getVerticalAlignment() { return verticalAlignment.toString(); }
    public boolean isBleed() { return bleed; }
    public BackGroundImage<TableCell<T>> getBackgroundImage() { return backgroundImage; }
    public String getMinHeight() { return minHeight; }
    public boolean isRtl() { return rtl; }

    /**
     * Protected default constructor for serialization.
     */
    protected TableCell() {
        super(null, null);
    }

    /**
     * Constructs a new TableCell with the specified parent.
     *
     * @param parent the parent object
     */
    protected TableCell(T parent) {
        super(parent, "TableCell");
    }

    /**
     * Sets the style of the cell.
     *
     * @param style the cell style
     * @return this cell for method chaining
     */
    public TableCell<T> setStyle(ContainerStyle style) {
        this.style = style;
        return this;
    }

    /**
     * Sets the vertical alignment of the cell content.
     *
     * @param verticalAlignment the vertical alignment
     * @return this cell for method chaining
     */
    public TableCell<T> setVerticalAlignment(VerticalContentAlignment verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
        return this;
    }

    /**
     * Sets whether the cell should bleed outside its parent.
     *
     * @param bleed true to enable bleed, false otherwise
     * @return this cell for method chaining
     */
    public TableCell<T> setBleed(boolean bleed) {
        this.bleed = bleed;
        return this;
    }

    /**
     * Adds a background image to the cell.
     *
     * @param url the URL of the background image
     * @return the created BackGroundImage object
     */
    public BackGroundImage<TableCell<T>> addBackgroundImage(String url) {
        this.backgroundImage = new BackGroundImage<>(this, url);
        return this.backgroundImage;
    }

    /**
     * Sets the minimum height of the cell.
     *
     * @param minHeight the minimum height as a string
     * @return this cell for method chaining
     */
    public TableCell<T> setMinHeight(String minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    /**
     * Sets whether the cell content should be rendered right-to-left.
     *
     * @param rtl true to enable RTL, false otherwise
     * @return this cell for method chaining
     */
    public TableCell<T> setRtl(boolean rtl) {
        this.rtl = rtl;
        return this;
    }
}
