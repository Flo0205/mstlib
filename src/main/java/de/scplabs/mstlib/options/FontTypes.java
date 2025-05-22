package de.scplabs.mstlib.options;

/**
 * Enum representing the possible font types for Text-Elemente in Adaptive Cards. <br>
 * Used to specify the font family for text rendering.
 */
public enum FontTypes {
    DEFAULT("default"),
    MONOSPACE("monospace");

    private final String fontType;

    FontTypes(final String fontType) {
        this.fontType = fontType;
    }

    @Override
    public String toString() {
        return fontType;
    }
}
