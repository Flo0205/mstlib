package de.scplabs.mstlib.options;

/**
 * Enum representing the possible color options for elements in adaptive cards. <br>
 * Used to specify the color scheme for text or container elements.
 */
public enum Colors {
    DEFAULT("default"),
    DARK("dark"),
    LIGHT("light"),
    ACCENT("accent"),
    GOOD("good"),
    WARNING("warning"),
    ATTENTION("attention");

    private final String color;

    Colors(final String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
