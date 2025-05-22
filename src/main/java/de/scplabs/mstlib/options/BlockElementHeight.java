package de.scplabs.mstlib.options;

/**
 * Enum representing the possible height options for block elements in Adaptive Cards. <br>
 * Used to control the vertical size of a block element.
 */
public enum BlockElementHeight {
    AUTO("auto"),
    STRETCH("stretch");

    private final String value;

    BlockElementHeight(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
