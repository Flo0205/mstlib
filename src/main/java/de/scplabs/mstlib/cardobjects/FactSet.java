package de.scplabs.mstlib.cardobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of facts in an adaptive card, allowing multiple key-value pairs (facts)
 * to be grouped together and displayed in a structured format.
 *
 * @param <T> the parent type
 */
public class FactSet<T extends CardParent<?>> extends CardSetObject<T, FactSet<T>> {

    private final List<Fact> facts = new ArrayList<>();

    public List<Fact> getFacts() { return facts; }

    /**
     * Protected default constructor for serialization.
     */
    protected FactSet() {
        super(null, null);
    }

    /**
     * Constructs a new FactSet with the specified parent.
     *
     * @param parent the parent object
     */
    public FactSet(T parent) {
        super(parent, "FactSet");
    }

    /**
     * Adds a new fact to this fact set.
     *
     * @param title the title (key) of the fact
     * @param value the value of the fact
     * @return this fact set for method chaining
     */
    public FactSet<T> addFact(String title, String value) {
        facts.add(new Fact(title, value));
        return this;
    }

    /**
     * Represents a single fact as a key-value pair.
     *
     * @param title the title (key) of the fact
     * @param value the value of the fact
     */
    public record Fact(String title, String value) { }
}
