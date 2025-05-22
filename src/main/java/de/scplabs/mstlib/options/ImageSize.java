package de.scplabs.mstlib.options;

/**
 * Enum representing the available image sizes for card elements. <br>
 * Used to specify the display size of images in adaptive cards.
 */
public enum ImageSize {
    AUTO("auto"),
    STRETCH("stretch"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String value;

    ImageSize(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
