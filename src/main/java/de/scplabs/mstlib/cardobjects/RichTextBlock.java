package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.scplabs.mstlib.options.HorizontalAlignments;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a rich text block in an adaptive card, allowing multiple text runs (inlines)
 * with different formatting to be grouped together. Supports horizontal alignment of the content.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RichTextBlock<T extends CardParent<?>> extends CardSetObject<T, RichTextBlock<T>> {

    private List<TextRun<RichTextBlock<T>>> inlines = new ArrayList<>();
    private HorizontalAlignments horizontalAlignment = HorizontalAlignments.LEFT;

    public List<TextRun<RichTextBlock<T>>> getInlines() { return inlines; }
    public String getHorizontalAlignment() { return horizontalAlignment.toString(); }

    /**
     * Protected default constructor for serialization.
     */
    protected RichTextBlock() {
        super(null, null);
    }

    /**
     * Constructs a new RichTextBlock with the specified parent.
     *
     * @param parent the parent object
     */
    public RichTextBlock(T parent) {
        super(parent, "RichTextBlock");
    }

    /**
     * Adds a new text run (inline) with the specified text to this rich text block.
     *
     * @param text the text content of the inline
     * @return the created TextRun object
     */
    public TextRun<RichTextBlock<T>> addInline(String text) {
        TextRun<RichTextBlock<T>> inline = new TextRun<>(this, text);
        inlines.add(inline);
        return inline;
    }

    /**
     * Sets the horizontal alignment of the rich text block.
     *
     * @param horizontalAlignment the horizontal alignment
     * @return this rich text block for method chaining
     */
    public RichTextBlock<T> setHorizontalAlignment(HorizontalAlignments horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
        return this;
    }
}
