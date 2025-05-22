package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.scplabs.mstlib.options.ContainerStyle;
import de.scplabs.mstlib.options.HorizontalAlignments;
import de.scplabs.mstlib.options.VerticalContentAlignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a table element in an adaptive card, allowing the definition of columns, rows, and cells,
 * as well as various layouts and style options such as grid lines, header row, and cell alignment.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Table<T extends CardParent<?>> extends CardObject<T, Table<T>> {

    private final List<TableColumnDefinition> columns = new ArrayList<>();
    private final List<TableRow<Table<T>>> rows = new ArrayList<>();
    private boolean firstRowAsHeader = true;
    private boolean showGridLines = true;
    private ContainerStyle gridStyle = ContainerStyle.DEFAULT;
    private HorizontalAlignments horizontalCellContentAlignment = HorizontalAlignments.LEFT;
    private VerticalContentAlignment verticalCellContentAlignment = VerticalContentAlignment.TOP;

    public List<TableColumnDefinition> getColumns() { return columns; }
    public List<TableRow<Table<T>>> getRows() { return rows; }
    public boolean isFirstRowAsHeader() { return firstRowAsHeader; }
    public boolean isShowGridLines() { return showGridLines; }
    public String getGridStyle() { return gridStyle.toString(); }
    public String getHorizontalCellContentAlignment() { return horizontalCellContentAlignment.toString(); }
    public String getVerticalCellContentAlignment() { return verticalCellContentAlignment.toString(); }

    /**
     * Protected default constructor for serialization.
     */
    protected Table() {
        super(null, null);
    }

    /**
     * Constructs a new Table with the specified parent.
     *
     * @param parent the parent object
     */
    public Table(T parent) {
        super(parent, "Table");
    }

    /**
     * Adds a new column definition with the specified width.
     *
     * @param width the width of the column
     * @return this table for method chaining
     */
    public Table<T> addColumns(int width) {
        this.columns.add(new TableColumnDefinition(String.valueOf(width)));
        return this;
    }

    /**
     * Adds a new row to the table.
     *
     * @return the created TableRow object
     */
    public TableRow<Table<T>> addRows() {
        TableRow<Table<T>> row = new TableRow<>(this);
        rows.add(row);
        return row;
    }

    /**
     * Sets whether the first row should be treated as a header.
     *
     * @param firstRowAsHeader true if the first row is a header, false otherwise
     * @return this table for method chaining
     */
    public Table<T> setFirstRowAsHeader(boolean firstRowAsHeader) {
        this.firstRowAsHeader = firstRowAsHeader;
        return this;
    }

    /**
     * Sets whether grid lines should be shown in the table.
     *
     * @param showGridLines true to show grid lines, false otherwise
     * @return this table for method chaining
     */
    public Table<T> setShowGridLines(boolean showGridLines) {
        this.showGridLines = showGridLines;
        return this;
    }

    /**
     * Sets the style of the table grid.
     *
     * @param gridStyle the grid style
     * @return this table for method chaining
     */
    public Table<T> setGridStyle(ContainerStyle gridStyle) {
        this.gridStyle = gridStyle;
        return this;
    }

    /**
     * Sets the horizontal alignment of cell content.
     *
     * @param horizontalCellContentAlignment the horizontal alignment
     * @return this table for method chaining
     */
    public Table<T> setHorizontalCellContentAlignment(HorizontalAlignments horizontalCellContentAlignment) {
        this.horizontalCellContentAlignment = horizontalCellContentAlignment;
        return this;
    }

    /**
     * Sets the vertical alignment of cell content.
     *
     * @param verticalCellContentAlignment the vertical alignment
     * @return this table for method chaining
     */
    public Table<T> setVerticalCellContentAlignment(VerticalContentAlignment verticalCellContentAlignment) {
        this.verticalCellContentAlignment = verticalCellContentAlignment;
        return this;
    }

    /**
     * Represents a column definition for the table, specifying the width.
     *
     * @param width the width of the column
     */
    public record TableColumnDefinition(String width) { }

    /**
     * Represents a row in the table, containing a list of cells and an optional style.
     *
     * @param <T> the parent type, must implement CardParent
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public static class TableRow<T extends CardParent<?>> extends CardObject<T, TableRow<T>> {

        private final List<TableCell<TableRow<T>>> cells = new ArrayList<>();
        private ContainerStyle style = ContainerStyle.DEFAULT;

        public List<TableCell<TableRow<T>>> getCells() { return cells; }
        public String getStyle() { return style.toString(); }

        /**
         * Protected default constructor for serialization.
         */
        protected TableRow() {
            super(null, null);
        }

        /**
         * Constructs a new TableRow with the specified parent.
         *
         * @param parent the parent object
         */
        protected TableRow(T parent) {
            super(parent, "TableRow");
        }

        /**
         * Adds a new cell to this row.
         *
         * @return the created TableCell object
         */
        public TableCell<TableRow<T>> addCell() {
            TableCell<TableRow<T>> cell = new TableCell<>(this);
            cells.add(cell);
            return cell;
        }

        /**
         * Sets the style of the row.
         *
         * @param style the row style
         * @return this row for method chaining
         */
        public TableRow<T> setStyle(ContainerStyle style) {
            this.style = style;
            return this;
        }
    }
}
