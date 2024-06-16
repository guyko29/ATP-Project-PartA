package algorithms.mazeGenerators;

/**
 * The Maze class represents a maze with specified rows and columns.
 * It allows setting start and goal positions, as well as manipulating
 * the maze grid cells.
 */
public class Maze {
    private final int row;
    private final int column;
    private int[][] grid;
    private Position start_position;
    private Position goal_position;

    /**
     * Constructs a Maze with specified rows, columns, start position, and goal position.
     * @param row the number of rows in the maze
     * @param column the number of columns in the maze
     * @param start_pos the starting position in the maze
     * @param goal_pos the goal position in the maze
     * @throws IllegalArgumentException if row or column is less than 2
     */
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

    /**
     * Gets the number of rows in the maze.
     * @return the number of rows
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the number of columns in the maze.
     * @return the number of columns
     */
    public int getColumn() {
        return column;
    }

    /**
     * Gets the maze grid.
     * @return the grid of the maze
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Sets the starting position of the maze.
     * @param row the row index of the starting position
     * @param column the column index of the starting position
     */
    public void setStart_pos(int row, int column) {
        start_position = new Position(row, column);
        setCellTo0(row, column);
    }

    /**
     * Sets the goal position of the maze.
     * @param pos the position of the goal
     */
    public void setGoal_pos(Position pos) {
        goal_position = pos;
    }

    /**
     * Sets a cell in the grid to 0.
     * @param row the row index of the cell
     * @param column the column index of the cell
     */
    public void setCellTo0(int row, int column) {
        grid[row][column] = 0;
    }

    /**
     * Sets a cell in the grid to 1.
     * @param row the row index of the cell
     * @param column the column index of the cell
     */
    public void setCellTo1(int row, int column) {
        grid[row][column] = 1;
    }

    /**
     * Sets the entire maze grid.
     * @param grid_map the grid to be set
     */
    public void setMaze_map(int[][] grid_map) {
        this.grid = grid_map;
    }

    /**
     * Gets the starting position of the maze.
     * @return the starting position
     */
    public Position getStartPosition() {
        return start_position;
    }

    /**
     * Gets the goal position of the maze.
     * @return the goal position
     */
    public Position getGoalPosition() {
        return goal_position;
    }

    /**
     * Gets the value of a cell in the grid.
     * @param row the row index of the cell
     * @param column the column index of the cell
     * @return the value of the cell, or -1 if the indices are out of bounds
     */
    public int getCell(int row, int column) {
        if (row < this.row && column < this.column) {
            return grid[row][column];
        }
        return -1;
    }

    /**
     * Prints the maze to the console.
     */
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
