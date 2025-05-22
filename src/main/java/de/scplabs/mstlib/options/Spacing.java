package de.scplabs.mstlib.options;

/**
 * Enum representing the available spacing options for card elements. <br>
 * Used to specify the amount of space around elements in adaptive cards.
 */
public enum Spacing {
    DEFAULT("default"),
    NONE("none"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    EXTRALARGE("extraLarge"),
    PADDING("padding");

    private final String value;

    Spacing(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
