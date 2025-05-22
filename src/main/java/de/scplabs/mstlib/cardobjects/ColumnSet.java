package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.scplabs.mstlib.options.ContainerStyle;
import de.scplabs.mstlib.options.HorizontalAlignments;

import java.util.List;

/**
 * Represents a set of columns in an adaptive card, allowing multiple columns to be grouped together
 * with shared layout and style options.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ColumnSet<T extends CardParent<?>> extends CardSetObject<T, ColumnSet<T>> {

    private List<Column<ColumnSet<T>>> columns;
    private ContainerStyle style = ContainerStyle.DEFAULT;
    private boolean bleed = false;
    private String minHeight = "";
    private HorizontalAlignments horizontalAlignment = HorizontalAlignments.LEFT;

    public List<Column<ColumnSet<T>>> getColumns() { return columns; }
    public String getStyle() { return style.toString(); }
    public boolean isBleed() { return bleed; }
    public String getMinHeight() { return minHeight; }
    public String getHorizontalAlignment() { return horizontalAlignment.toString(); }

    /**
     * Protected default constructor for serialization.
     */
    protected ColumnSet() {
        super(null, null);
    }

    /**
     * Constructs a new ColumnSet with the specified parent.
     *
     * @param parent the parent object
     */
    public ColumnSet(T parent) {
        super(parent, "ColumnSet");
    }

    /**
     * Adds a new Column with the specified parent.
     *
     * @return the created column for method chaining
     */
    public Column<ColumnSet<T>> addColumn() {
        Column<ColumnSet<T>> column = new Column<>(this);
        columns.add(column);
        return column;
    }

    /**
     * Sets the style of the column set.
     *
     * @param style the container style
     * @return this column set for method chaining
     */
    public ColumnSet<T> setStyle(ContainerStyle style) {
        this.style = style;
        return this;
    }

    /**
     * Sets whether the column set should bleed outside its parent padding.
     *
     * @param bleed true to enable bleed, false otherwise
     * @return this column set for method chaining
     */
    public ColumnSet<T> setBleed(boolean bleed) {
        this.bleed = bleed;
        return this;
    }

    /**
     * Sets the minimum height of the column set.
     *
     * @param minHeight the minimum height as a string
     * @return this column set for method chaining
     */
    public ColumnSet<T> setMinHeight(String minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    /**
     * Sets the horizontal alignment of the columns.
     *
     * @param horizontalAlignment the horizontal alignment
     * @return this column set for method chaining
     */
    public ColumnSet<T> setHorizontalAlignment(HorizontalAlignments horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
        return this;
    }
}
