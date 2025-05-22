package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.scplabs.mstlib.options.Colors;
import de.scplabs.mstlib.options.FontSize;
import de.scplabs.mstlib.options.FontTypes;
import de.scplabs.mstlib.options.FontWeights;

/**
 * Represents a single text run (inline text element) in an adaptive card, allowing configuration
 * of text content, color, font type, highlight, subtlety, italic, size, strikethrough, underline, and weight.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TextRun<T extends CardParent<?>> extends CardObject<T, TextRun<T>> {

    private String text = "";
    private Colors color = Colors.DEFAULT;
    private FontTypes fontType = FontTypes.DEFAULT;
    private boolean highlight = false;
    private boolean isSubtle = false;
    private boolean italic = false;
    private FontSize size = FontSize.DEFAULT;
    private boolean strikethrough = false;
    private boolean underline = false;
    private FontWeights weight = FontWeights.DEFAULT;

    public String getText() { return text; }
    public String getColor() { return color.toString(); }
    public String getFontType() { return fontType.toString(); }
    public boolean isHighlight() { return highlight; }
    public boolean isIsSubtle() { return isSubtle; }
    public boolean isItalic() { return italic; }
    public String getSize() { return size.toString(); }
    public boolean isStrikethrough() { return strikethrough; }
    public boolean isUnderline() { return underline; }
    public String getWeight() { return weight.toString(); }

    /**
     * Protected default constructor for serialization.
     */
    protected TextRun() {
        super(null, null);
    }

    /**
     * Constructs a new TextRun with the specified parent and text.
     *
     * @param parent the parent object
     * @param text the text content
     */
    protected TextRun(T parent, String text) {
        super(parent, "TextRun");
        this.text = text;
    }

    /**
     * Sets the color of the text.
     *
     * @param color the color to set
     * @return this text run for method chaining
     */
    public TextRun<T> setColor(Colors color) {
        this.color = color;
        return this;
    }

    /**
     * Sets the font type.
     *
     * @param fontType the font type to set
     * @return this text run for method chaining
     */
    public TextRun<T> setFontType(FontTypes fontType) {
        this.fontType = fontType;
        return this;
    }

    /**
     * Sets whether the text is highlighted.
     *
     * @param highlight true to highlight, false otherwise
     * @return this text run for method chaining
     */
    public TextRun<T> setHighlight(boolean highlight) {
        this.highlight = highlight;
        return this;
    }

    /**
     * Sets whether the text is subtle.
     *
     * @param subtle true to make the text subtle, false otherwise
     * @return this text run for method chaining
     */
    public TextRun<T> setSubtle(boolean subtle) {
        isSubtle = subtle;
        return this;
    }

    /**
     * Sets whether the text is italicized.
     *
     * @param italic true to italicize, false otherwise
     * @return this text run for method chaining
     */
    public TextRun<T> setItalic(boolean italic) {
        this.italic = italic;
        return this;
    }

    /**
     * Sets the font size.
     *
     * @param size the font size to set
     * @return this text run for method chaining
     */
    public TextRun<T> setSize(FontSize size) {
        this.size = size;
        return this;
    }

    /**
     * Sets whether the text has a strikethrough.
     *
     * @param strikethrough true to add strikethrough, false otherwise
     * @return this text run for method chaining
     */
    public TextRun<T> setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    /**
     * Sets whether the text is underlined.
     *
     * @param underline true to underline, false otherwise
     * @return this text run for method chaining
     */
    public TextRun<T> setUnderline(boolean underline) {
        this.underline = underline;
        return this;
    }

    /**
     * Sets the font weight.
     *
     * @param weight the font weight to set
     * @return this text run for method chaining
     */
    public TextRun<T> setWeight(FontWeights weight) {
        this.weight = weight;
        return this;
    }
}
