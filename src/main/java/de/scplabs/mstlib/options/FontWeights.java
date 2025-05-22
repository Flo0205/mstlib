package de.scplabs.mstlib.options;

/**
 * Enum representing the possible font weights for text elements in adaptive cards. <br>
 * Used to specify the thickness or boldness of the font.
 */
public enum FontWeights {
    DEFAULT("default"),
    LIGHTER("lighter"),
    BOLDER("bolder");

    private final String fontWeight;

    FontWeights(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    @Override
    public String toString() {
        return fontWeight;
    }
}
