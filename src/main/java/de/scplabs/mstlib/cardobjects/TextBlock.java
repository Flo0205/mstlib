package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.scplabs.mstlib.options.*;

/**
 * Represents a text block element in an adaptive card, allowing configuration of text content,
 * color, font type, alignment, subtlety, size, weight, wrapping, and style.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TextBlock<T extends CardParent<?>> extends CardObject<T, TextBlock<T>> {

    private String text = "";
    private Colors color = Colors.DEFAULT;
    private FontTypes fontType = FontTypes.DEFAULT;
    private HorizontalAlignments horizontalAlignment = HorizontalAlignments.LEFT;
    private boolean isSubtle = false;
    // maxLines
    private FontTypes size = FontTypes.DEFAULT;
    private FontWeights weight = FontWeights.DEFAULT;
    private boolean wrap = true;
    private TextBlockStyles style = TextBlockStyles.DEFAULT;

    public String getText() { return text; }
    public String getColor() { return color.toString(); }
    public String getFontType() { return fontType.toString(); }
    public String getHorizontalAlignment() { return horizontalAlignment.toString(); }
    public boolean isIsSubtle() { return isSubtle; }
    public String getSize() { return size.toString(); }
    public String getWeight() { return weight.toString(); }
    public boolean isWrap() { return wrap; }
    public String getStyle() { return style.toString(); }

    /**
     * Protected default constructor for serialization.
     */
    protected TextBlock() {
        super(null, null);
    }

    /**
     * Constructs a new TextBlock with the specified parent and text.
     *
     * @param parent the parent object
     * @param text the text content
     */
    public TextBlock(T parent, String text) {
        super(parent, "TextBlock");
        this.text = text;
    }

    /**
     * Sets the color of the text.
     *
     * @param color the color to set
     * @return this text block for method chaining
     */
    public TextBlock<T> setColor(Colors color) {
        this.color = color;
        return this;
    }

    /**
     * Sets the font type.
     *
     * @param fontType the font type to set
     * @return this text block for method chaining
     */
    public TextBlock<T> setFontType(FontTypes fontType) {
        this.fontType = fontType;
        return this;
    }

    /**
     * Sets the horizontal alignment.
     *
     * @param horizontalAlignment the alignment to set
     * @return this text block for method chaining
     */
    public TextBlock<T> setHorizontalAlignment(HorizontalAlignments horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
        return this;
    }

    /**
     * Sets whether the text is subtle.
     *
     * @param subtle true to make the text subtle, false otherwise
     * @return this text block for method chaining
     */
    public TextBlock<T> setSubtle(boolean subtle) {
        isSubtle = subtle;
        return this;
    }

    /**
     * Sets the font size.
     *
     * @param size the font size to set
     * @return this text block for method chaining
     */
    public TextBlock<T> setSize(FontTypes size) {
        this.size = size;
        return this;
    }

    /**
     * Sets the font weight.
     *
     * @param weight the font weight to set
     * @return this text block for method chaining
     */
    public TextBlock<T> setWeight(FontWeights weight) {
        this.weight = weight;
        return this;
    }

    /**
     * Sets whether the text should wrap.
     *
     * @param wrap true to enable wrapping, false otherwise
     * @return this text block for method chaining
     */
    public TextBlock<T> setWrap(boolean wrap) {
        this.wrap = wrap;
        return this;
    }

    /**
     * Sets the style of the text block.
     *
     * @param style the style to set
     * @return this text block for method chaining
     */
    public TextBlock<T> setStyle(TextBlockStyles style) {
        this.style = style;
        return this;
    }
}
