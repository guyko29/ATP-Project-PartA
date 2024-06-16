package algorithms.mazeGenerators;

/**
 * The Position class represents a position in a 2D grid with specified row and column indices.
 */
public class Position {
    private final int row;
    private final int column;

    /**
     * Constructs a Position with specified row and column indices.
     * @param row the row index
     * @param column the column index
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the row index of the position.
     * @return the row index
     */
    public int getRowIndex() {
        return row;
    }

    /**
     * Gets the column index of the position.
     * @return the column index
     */
    public int getColumnIndex() {
        return column;
    }

    /**
     * Returns a string representation of the position.
     * @return a string in the format "{row,column}"
     */
    @Override
    public String toString() {
        return "{" + row + "," + column + "}";
    }

    /**
     * Checks if this position is equal to another position.
     * @param check_position the position to compare with
     * @return true if the positions are equal, false otherwise
     */
    public boolean equals(Position check_position) {
        return this.row == check_position.getRowIndex() && this.column == check_position.getColumnIndex();
    }
}
