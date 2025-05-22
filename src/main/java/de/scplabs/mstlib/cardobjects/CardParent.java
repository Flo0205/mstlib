package de.scplabs.mstlib.cardobjects;

/**
 * Represents a parent interface for card objects.
 * <p>
 * The generic type parameter {@code T} allows implementations to specify their own type,
 * enabling fluent builder patterns and type-safe parent-child relationships.
 * </p>
 *
 * @param <T> the type of the parent, which must also implement {@code CardParent}
 */
public interface CardParent<T extends CardParent<?>> { }
