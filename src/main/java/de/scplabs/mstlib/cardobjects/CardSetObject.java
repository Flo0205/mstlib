package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Abstract base class for card set objects that group multiple card elements.
 *
 * @param <T>    the parent type
 * @param <SELF> the concrete type of the card set object (for fluent API)
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class CardSetObject<T extends CardParent<?>, SELF extends CardSetObject<T, SELF>> extends CardObject<T, SELF> {

    /**
     * Constructs a new CardSetObject.
     *
     * @param parent the parent object
     * @param type   the type of the card set object
     */
    protected CardSetObject(T parent, String type) {
        super(parent, type);
    }
}
