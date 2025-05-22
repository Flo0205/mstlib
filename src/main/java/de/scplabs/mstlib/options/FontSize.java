package de.scplabs.mstlib.options;

/**
 * Enum representing the possible font sizes for text elements in adaptive cards. <br>
 * Used to specify the size of the font for text rendering.
 */
public enum FontSize {
    DEFAULT("default"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    EXTRALARGE("extraLarge");

    private final String value;

    FontSize(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
