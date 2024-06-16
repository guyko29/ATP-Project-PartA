package algorithms.mazeGenerators;

/**
 * The IMazeGenerator interface provides methods for generating mazes and measuring
 * the time taken to generate them.
 */
public interface IMazeGenerator {

    /**
     * Generates a maze with the specified number of rows and columns.
     *
     * @param row the number of rows in the maze
     * @param column the number of columns in the maze
     * @return a Maze object representing the generated maze
     */
    Maze generate(int row, int column);

    /**
     * Measures the time taken to generate a maze with the specified number of rows
     * and columns.
     *
     * @param row the number of rows in the maze
     * @param column the number of columns in the maze
     * @return the time taken to generate the maze, in milliseconds
     */
    long measureAlgorithmTimeMillis(int row, int column);
}
