package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
 * The MyMazeGenerator class generates a maze using a randomized algorithm.
 * It extends the abstract class AMazeGenerator.
 */
public class MyMazeGenerator extends AMazeGenerator {
    private final Random random = new Random();

    /**
     * Generates a maze with specified rows and columns.
     * The maze is generated using a randomized algorithm to create paths.
     * @param row the number of rows in the maze
     * @param column the number of columns in the maze
     * @return a Maze object with randomly generated paths
     */
    @Override
    public Maze generate(int row, int column) {
        Position start_pos = new Position(0, 0);
        Position goal_pos = new Position(row - 1, column - 1);
        Maze maze = new Maze(row, column, start_pos, goal_pos);
        int[][] grid_maze = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                grid_maze[r][c] = 1;
            }
        }
        grid_maze[0][0] = 0;
        ArrayList<Position> walls = new ArrayList<>();
        walls.add(new Position(0, 1)); // START RIGHT
        walls.add(new Position(1, 0)); // START BOTTOM
        while (!walls.isEmpty()) {
            int wall_index = random.nextInt(walls.size());
            Position new_position = walls.get(wall_index);
            if (new_position.getRowIndex() % 2 != 0) {
                createWallOddRow(new_position.getRowIndex(), new_position.getColumnIndex(), row, column, walls, grid_maze);
            } else {
                createWallOddColumn(new_position.getRowIndex(), new_position.getColumnIndex(), row, column, walls, grid_maze);
            }
            walls.remove(wall_index);
        }
        if (column % 2 == 0) {
            for (int i = column - 1; i >= 0; i--) {
                if (grid_maze[row - 2][i] == 0) {
                    grid_maze[row - 1][i] = 0;
                    maze.setGoal_pos(new Position(row - 1, i));
                    break;
                }
            }
        }
        maze.setMaze_map(grid_maze);
        return maze;
    }

    /**
     * Checks if the specified row and column indices are within the bounds of the grid.
     * @param row the row index to check
     * @param column the column index to check
     * @param grid_row the number of rows in the grid
     * @param grid_col the number of columns in the grid
     * @return true if the indices are within bounds, false otherwise
     */
    public boolean checkRangeGrid(int row, int column, int grid_row, int grid_col) {
        return !(row < 0 || column < 0 || row >= grid_row || column >= grid_col);
    }

    /**
     * Creates a wall for an odd row index in the maze.
     * @param row_pos the row index of the wall
     * @param column_pos the column index of the wall
     * @param rows the total number of rows in the maze
     * @param columns the total number of columns in the maze
     * @param walls the list of walls to update
     * @param grid the maze grid
     */
    public void createWallOddRow(int row_pos, int column_pos, int rows, int columns, ArrayList<Position> walls, int[][] grid) {
        if (checkRangeGrid(row_pos + 1, column_pos, rows, columns)) {
            if (!(grid[row_pos - 1][column_pos] == 0 && grid[row_pos + 1][column_pos] == 0)) {
                if (grid[row_pos - 1][column_pos] == 1) {
                    grid[row_pos][column_pos] = 0;
                    grid[row_pos - 1][column_pos] = 0;
                    addNeighborWall(row_pos - 1, column_pos, rows, columns, walls, grid);
                } else {
                    grid[row_pos][column_pos] = 0;
                    grid[row_pos + 1][column_pos] = 0;
                    addNeighborWall(row_pos + 1, column_pos, rows, columns, walls, grid);
                }
            }
        }
    }

    /**
     * Creates a wall for an odd column index in the maze.
     * @param row_pos the row index of the wall
     * @param column_pos the column index of the wall
     * @param rows the total number of rows in the maze
     * @param columns the total number of columns in the maze
     * @param walls the list of walls to update
     * @param grid the maze grid
     */
    public void createWallOddColumn(int row_pos, int column_pos, int rows, int columns, ArrayList<Position> walls, int[][] grid) {
        if (checkRangeGrid(row_pos, column_pos + 1, rows, columns) && checkRangeGrid(row_pos, column_pos - 1, rows, columns)) {
            if (!(grid[row_pos][column_pos + 1] == 0 && grid[row_pos][column_pos - 1] == 0)) {
                if (grid[row_pos][column_pos - 1] == 1) {
                    grid[row_pos][column_pos] = 0;
                    grid[row_pos][column_pos - 1] = 0;
                    addNeighborWall(row_pos, column_pos - 1, rows, columns, walls, grid);/**
                     * The MyMazeGenerator class generates a maze using a randomized algorithm.
                     * It extends the abstract class AMazeGenerator.
                     */
                } else {
                    grid[row_pos][column_pos] = 0;
                    grid[row_pos][column_pos + 1] = 0;
                    addNeighborWall(row_pos, column_pos + 1, rows, columns, walls, grid);
                }
            }
        }
    }

    /**
     * Adds neighboring walls to the list of walls.
     * @param row_pos the row index of the current wall
     * @param column_pos the column index of the current wall
     * @param rows the total number of rows in the maze
     * @param columns the total number of columns in the maze
     * @param walls the list of walls to update
     * @param grid the maze grid
     */
    public void addNeighborWall(int row_pos, int column_pos, int rows, int columns, ArrayList<Position> walls, int[][] grid) {
        // check up neighbor
        if (checkRangeGrid(row_pos - 1, column_pos, rows, columns) && grid[row_pos - 1][column_pos] == 1 && !(walls.contains(new Position(row_pos - 1, column_pos)))) {
            walls.add(new Position(row_pos - 1, column_pos));
        }
        //check down neighbor
        if (checkRangeGrid(row_pos + 1,column_pos, rows, columns)  && grid[row_pos + 1][column_pos] == 1 && !(walls.contains(new Position(row_pos + 1, column_pos)))) {
            walls.add(new Position(row_pos + 1,column_pos));
        }
        // check left neighbor
        if (checkRangeGrid(row_pos,column_pos - 1, rows, columns) && grid[row_pos][column_pos - 1] == 1 && !(walls.contains(new Position(row_pos,column_pos - 1)))) {
            walls.add(new Position(row_pos,column_pos - 1));
        }
        // check right neighbor
        if (checkRangeGrid(row_pos,column_pos + 1, rows, columns) && grid[row_pos][column_pos + 1] == 1 && !(walls.contains(new Position(row_pos,column_pos + 1)))) {
            walls.add(new Position(row_pos,column_pos + 1));
        }
    }

}