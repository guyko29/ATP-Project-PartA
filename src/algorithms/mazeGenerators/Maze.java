package algorithms.mazeGenerators;

public class Maze {
    private final int row;
    private final int column;
    private int[][] grid;

    private Position start_pos;
    private Position goal_pos;

    public Maze(int row, int column) {
        this.row = row;
        this.column = column;
        this.grid = new int[row][column];
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
        start_pos = new Position(row, column);
        setCellTo0(row, column);
    }
    public void setGoal_pos(int row, int column) {
        goal_pos = new Position(row, column);
        setCellTo0(row, column);
    }

    public void setCellTo0(int row, int column) {
        grid[row][column] = 0;
    }

    public void setCellTo1(int row, int column) {
        grid[row][column] = 1;
    }

    public Position getStartPosition() {
        return start_pos;
    }

    public Position getGoalPosition() {
        return goal_pos;
    }

    public void print() {
        StringBuilder mazeStr = new StringBuilder();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (r == start_pos.getRowIndex() && c == start_pos.getColumnIndex()) {
                    mazeStr.append(" ").append("S");
                } else if (r == goal_pos.getRowIndex() && c == goal_pos.getColumnIndex()) {
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
