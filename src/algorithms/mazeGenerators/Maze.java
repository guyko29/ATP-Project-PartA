package algorithms.mazeGenerators;

public class Maze {
    private final int row;
    private final int column;
    private int[][] grid;

    private Position start_position;
    private Position goal_position;

    public Maze(int row, int column, Position start_pos, Position goal_pos) {
        if (row < 2 || column < 2) {
            throw new IllegalArgumentException("Row and column must be greater than 1.");
        }
        this.row = row;
        this.column = column;
        this.grid = new int[row][column];
        this.start_position = start_pos;
        this.goal_position = goal_pos;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setStart_pos(int row, int column) {
        start_position = new Position(row, column);
        setCellTo0(row, column);
    }
    public void setGoal_pos(int row, int column) {
        goal_position = new Position(row, column);
        setCellTo0(row, column);
    }

    public void setCellTo0(int row, int column) {
        grid[row][column] = 0;
    }

    public void setCellTo1(int row, int column) {
        grid[row][column] = 1;
    }

    public Position getStartPosition() {
        return start_position;
    }

    public Position getGoalPosition() {
        return goal_position;
    }

    public int getCell(int row, int column) {
        if (row < this.row && column < this.column) {
            return grid[row][column];
        }
        return -1;
    }

    public void print() {
        StringBuilder mazeStr = new StringBuilder();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (r == start_position.getRowIndex() && c == start_position.getColumnIndex()) {
                    mazeStr.append(" ").append("S");
                } else if (r == goal_position.getRowIndex() && c == goal_position.getColumnIndex()) {
                    mazeStr.append(" ").append("E");
                } else {
                    mazeStr.append(" ").append(grid[r][c]);
                }
            }
            mazeStr.append("\n");
        }
        System.out.println(mazeStr.toString());
    }
}
