package algorithms.mazeGenerators;

/**
 * The EmptyMazeGenerator class generates an empty maze with all cells set to 0.
 * It extends the abstract class AMazeGenerator.
 */
public class EmptyMazeGenerator extends AMazeGenerator {

    /**
     * Constructs an EmptyMazeGenerator.
     */
    public EmptyMazeGenerator() {}

    /**
     * Generates an empty maze with specified rows and columns.
     * @param row the number of rows in the maze
     * @param column the number of columns in the maze
     * @return a Maze object with all cells set to 0
     */
    @Override
    public Maze generate(int row, int column) {
        Position start_pos = new Position(0, 0);
        Position goal_pos = new Position(row - 1, column - 1);
        Maze maze = new Maze(row, column, start_pos, goal_pos);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                maze.setCellTo0(r, c);
            }
        }
        return maze;
    }
}
