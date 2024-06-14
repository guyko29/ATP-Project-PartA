package algorithms.mazeGenerators;

public class Position {
    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return column;
    }

    @Override
    public String toString() {
        return "{" + row + "," + column + "}";
    }

    public boolean equals(Position check_position){
        return this.row == check_position.getRowIndex() && this.column == check_position.getColumnIndex();
    }
}