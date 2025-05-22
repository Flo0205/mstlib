package de.scplabs.mstlib.options;

/**
 * Enum representing the vertical content alignment options for card elements.<br>
 * Provides string values for use in serialization or API communication.
 */
public enum VerticalContentAlignment {
    /** Aligns content to the top. */
    TOP("top"),
    /** Centers the content vertically. */
    CENTER("center"),
    /** Aligns content to the bottom. */
    BOTTOM("bottom");

    private final String value;

    VerticalContentAlignment(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
