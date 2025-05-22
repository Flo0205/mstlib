package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.scplabs.mstlib.options.BlockElementHeight;
import de.scplabs.mstlib.options.Spacing;

/**
 * Abstract base class for all card objects that can be part of an adaptive card.
 *
 * @param <T>    the parent type
 * @param <SELF> the concrete type of the card object (for fluent API)
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class CardObject<T extends CardParent<?>, SELF extends CardObject<T, SELF>> implements CardParent<T> {
    /**
     * The parent object of this card object.
     */
    protected T parent;

    /**
     * Returns the parent object of this card object.
     *
     * @return the parent object
     */
    public T prev() { return parent; }

    @JsonProperty(required = true)
    private String type;

    private BlockElementHeight height = BlockElementHeight.AUTO;
    private boolean separator = false;
    private Spacing spacing = Spacing.DEFAULT;
    private boolean isVisible = true;

    public String getType() { return type; }
    public String getHeight() { return height.toString(); }
    public boolean isSeparator() { return separator; }
    public String getSpacing() { return spacing.toString(); }
    public boolean isVisible() { return isVisible; }

    /**
     * Constructs a new CardObject.
     *
     * @param parent the parent object
     * @param type   the type of the card object
     */
    protected CardObject(T parent, String type) {
        this.parent = parent;
        this.type = type;
    }

    /**
     * Sets the height of this card element.
     *
     * @param height the height to set
     * @return this object for method chaining
     */
    @SuppressWarnings("unchecked")
    public SELF setHeight(BlockElementHeight height) {
        this.height = height;
        return (SELF) this;
    }

    /**
     * Sets whether a separator should be shown before this element.
     *
     * @param separator true to show a separator, false otherwise
     * @return this object for method chaining
     */
    @SuppressWarnings("unchecked")
    public SELF setSeparator(boolean separator) {
        this.separator = separator;
        return (SELF) this;
    }

    /**
     * Sets the spacing before this element.
     *
     * @param spacing the spacing to set
     * @return this object for method chaining
     */
    @SuppressWarnings("unchecked")
    public SELF setSpacing(Spacing spacing) {
        this.spacing = spacing;
        return (SELF) this;
    }

    /**
     * Sets whether this element is visible.
     *
     * @param visible true if the element should be visible, false otherwise
     * @return this object for method chaining
     */
    @SuppressWarnings("unchecked")
    public SELF setVisible(boolean visible) {
        isVisible = visible;
        return (SELF) this;
    }
}
