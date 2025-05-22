package de.scplabs.mstlib.options;

/**
 * Enum representing the available styles for a TextBlock element. <br>
 * Used to specify the visual style of text blocks in adaptive cards.
 */
public enum TextBlockStyles {
    /** Default text block style. */
    DEFAULT("default"),
    /** Heading style for text blocks. */
    HEADING("heading");

    private final String textBlockStyle;

    TextBlockStyles(String textBlockStyle) {
        this.textBlockStyle = textBlockStyle;
    }

    @Override
    public String toString() {
        return textBlockStyle;
    }
}
