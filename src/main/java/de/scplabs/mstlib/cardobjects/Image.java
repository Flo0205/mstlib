package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.scplabs.mstlib.options.BlockElementHeight;
import de.scplabs.mstlib.options.HorizontalAlignments;
import de.scplabs.mstlib.options.ImageSize;
import de.scplabs.mstlib.options.ImageStyle;

/**
 * Represents an image element in an adaptive card, supporting various display and layout options.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Image<T extends CardParent<?>> extends CardObject<T, Image<T>> {

    private String url;
    private String altText = "";
    private String backgroundColor = "";
    private String height = "";
    private HorizontalAlignments horizontalAlignment = HorizontalAlignments.LEFT;
    private ImageSize size = ImageSize.AUTO;
    private ImageStyle style = ImageStyle.DEFAULT;
    private String width = "";

    public String getUrl() { return url; }
    public String getAltText() { return altText; }
    public String getBackgroundColor() { return backgroundColor; }
    @Override
    public String getHeight() { return height; }
    public String getHorizontalAlignment() { return horizontalAlignment.toString(); }
    public String getSize() { return size.toString(); }
    public String getStyle() { return style.toString(); }
    public String getWidth() { return width; }

    /**
     * Protected default constructor for serialization.
     */
    protected Image() {
        super(null, null);
    }

    /**
     * Constructs a new Image with the specified parent and URL.
     *
     * @param parent the parent object
     * @param url    the URL of the image
     */
    public Image(T parent, String url) {
        super(parent, "Image");
        this.url = url;
    }

    /**
     * Sets the alternative text for the image.
     *
     * @param altText the alt text
     * @return this image for method chaining
     */
    public Image<T> setAltText(String altText) {
        this.altText = altText;
        return this;
    }

    /**
     * Sets the background color of the image.
     *
     * @param backgroundColor the background color
     * @return this image for method chaining
     */
    public Image<T> setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Sets the height of the image.
     *
     * @param height the height as a string
     * @return this image for method chaining
     */
    public Image<T> setHeight(String height) {
        this.height = height;
        return this;
    }

    /**
     * Sets the height of the image using a BlockElementHeight enum.
     *
     * @param height the block element height
     * @return this image for method chaining
     */
    @Override
    public Image<T> setHeight(BlockElementHeight height) {
        return setHeight(height.toString());
    }

    /**
     * Sets the horizontal alignment of the image.
     *
     * @param horizontalAlignment the horizontal alignment
     * @return this image for method chaining
     */
    public Image<T> setHorizontalAlignment(HorizontalAlignments horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
        return this;
    }

    /**
     * Sets the size of the image.
     *
     * @param size the image size
     * @return this image for method chaining
     */
    public Image<T> setSize(ImageSize size) {
        this.size = size;
        return this;
    }

    /**
     * Sets the style of the image.
     *
     * @param style the image style
     * @return this image for method chaining
     */
    public Image<T> setStyle(ImageStyle style) {
        this.style = style;
        return this;
    }

    /**
     * Sets the width of the image.
     *
     * @param width the width as a string
     * @return this image for method chaining
     */
    public Image<T> setWidth(String width) {
        this.width = width;
        return this;
    }
}
