package de.scplabs.mstlib.options;

/**
 * Enum representing the available styles for an ImageSet element. <br>
 * Used to specify how images are arranged in adaptive cards.
 */
public enum ImageSetStyle {
    DEFAULT("default"),
    STACKED("stacked"),
    GRID("grid"),;

    private final String value;

    ImageSetStyle(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
