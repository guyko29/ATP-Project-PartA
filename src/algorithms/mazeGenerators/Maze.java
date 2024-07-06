package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * The Maze class represents a maze with specified rows and columns.
 * It allows setting start and goal positions, as well as manipulating
 * the maze grid cells.
 */
public class Maze implements Serializable {
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

    public Maze(byte[] represent_maze) {
        byte[] start_position = new byte[2];
        start_position[0] = represent_maze[0];
        start_position[1] = represent_maze[1];
        this.start_position = new Position(fromByte_ToInt(start_position),fromByte_ToInt(start_position));
        byte[] column_goal_bytes = new byte[2];
        column_goal_bytes[0] = represent_maze[2];
        column_goal_bytes[1] = represent_maze[3];
        int column_goal = fromByte_ToInt(column_goal_bytes);
        byte[] row_goal_bytes = new byte[2];
        row_goal_bytes[0] = represent_maze[4];
        row_goal_bytes[1] = represent_maze[5];
        int row_goal = fromByte_ToInt(row_goal_bytes);
        this.goal_position = new Position(row_goal, column_goal);
        byte[] total_rows = new byte[2];
        total_rows[0] = represent_maze[6];
        total_rows[1] = represent_maze[7];
        this.row = fromByte_ToInt(total_rows);
        byte[] total_columns = new byte[2];
        total_columns[0] = represent_maze[8];
        total_columns[1] = represent_maze[9];
        this.column = fromByte_ToInt(total_columns);
        grid = new int [row][column];
        int index = 10;
        for (int r = 0; r < row; r++){
            for (int col = 0; col < column; col++){
                this.grid[r][col] = represent_maze[index];
                index++;
            }
        }
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

    public byte[] toByteArray() {
        byte[] represent_maze = new byte[10 + this.row * this.column];
        represent_maze[0] = 0;
        represent_maze[1] = 0;
        byte[] goal_position_column = fromInt_ToByte(this.goal_position.getColumnIndex());
        byte[] goal_position_row = fromInt_ToByte(this.goal_position.getRowIndex());
        represent_maze[2] = goal_position_column[0];
        represent_maze[3] = goal_position_column[1];
        represent_maze[4] = goal_position_row[0];
        represent_maze[5] = goal_position_row[1];
        byte[] total_rows = fromInt_ToByte(row);
        represent_maze[6] = total_rows[0];
        represent_maze[7] = total_rows[1];
        byte[] total_columns = fromInt_ToByte(column);
        represent_maze[8] = total_columns[0];
        represent_maze[9] = total_columns[1];
        int index = 10;
        for (int r = 0; r < row; r++){
            for (int col = 0; col < column; col++){
                represent_maze[index] = (byte) this.grid[r][col];
                index++;
            }
        }
        return represent_maze;
    }

    public byte[] fromInt_ToByte(int num_to_convert) {
        byte[] byte_represent = new byte[2];
        int byte1 = (num_to_convert >> 8) & 0xFF; // Most significant byte
        int byte2 = num_to_convert & 0xFF; // Least significant byte
        byte_represent[0] = (byte) byte1;
        byte_represent[1] = (byte) byte2;
        return byte_represent;
    }

    public int fromByte_ToInt(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 8) | (bytes[1] & 0xFF);
    }

    public String getMazeDetails(){
        String maze_details = "";
        maze_details += goal_position.getRowIndex() + goal_position.getColumnIndex() + row + column;
        for (int r = 0; r < row; r++){
            for (int col = 0; col < column; col++) {
                maze_details += this.grid[r][col];
            }
        }
        return maze_details;
    }
}
