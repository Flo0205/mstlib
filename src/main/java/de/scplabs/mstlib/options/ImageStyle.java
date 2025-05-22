package de.scplabs.mstlib.options;

/**
 * Enum representing the available image styles for card elements. <br>
 * Used to specify the visual style of images in adaptive cards.
 */
public enum ImageStyle {
    /** Default image style. */
    DEFAULT("default"),
    /** Person image style, typically used for profile pictures. */
    PERSON("person");

    private final String value;

    ImageStyle(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
