package de.scplabs.mstlib.options;

/**
 * Enum representing the possible horizontal alignments for elements in adaptive cards. <br>
 * Used to specify how content should be aligned horizontally.
 */
public enum HorizontalAlignments {
    /** Aligns content to the left. */
    LEFT("left"),
    /** Centers the content. */
    CENTER("center"),
    /** Aligns content to the right. */
    RIGHT("right");

    private final String horizontalAlignment;

    HorizontalAlignments(final String horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    @Override
    public String toString() {
        return horizontalAlignment;
    }
}
