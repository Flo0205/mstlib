package de.scplabs.mstlib.options;

/**
 * Enum representing the possible container styles for adaptive cards. <br>
 * Used to specify the visual appearance of a container.
 */
public enum ContainerStyle {
    DEFAULT("default"),
    EMPHASIS("emphasis"),
    GOOD("good"),
    ATTENTION("attention"),
    WARNING("warning"),
    ACCENT("accent");

    private final String value;

    ContainerStyle(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
