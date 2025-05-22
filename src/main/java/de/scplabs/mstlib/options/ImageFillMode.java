package de.scplabs.mstlib.options;

/**
 * Enum representing the available fill modes for images in adaptive cards. <br>
 * Used to specify how an image should be displayed within its container.
 */
public enum ImageFillMode {
    /** Scales the image to cover the entire container, cropping if necessary. */
    COVER("cover"),
    /** Repeats the image horizontally to fill the container. */
    REPEATHORIZONTALLY("repeatHorizontally"),
    /** Repeats the image vertically to fill the container. */
    REPEATHVERTICALLY("repeatVertically"),
    /** Repeats the image both horizontally and vertically to fill the container. */
    REPEAT("repeat");

    private final String value;

    ImageFillMode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
