package algorithms.mazeGenerators;

/**
 * The AMazeGenerator abstract class provides a default implementation for measuring
 * the time taken to generate a maze. Classes that extend this abstract class need to
 * implement the generate method defined in the IMazeGenerator interface.
 */
public abstract class AMazeGenerator implements IMazeGenerator {

    /**
     * Measures the time taken to generate a maze with the specified number of rows
     * and columns.
     *
     * @param row the number of rows in the maze
     * @param column the number of columns in the maze
     * @return the time taken to generate the maze, in milliseconds
     */
    @Override
    public long measureAlgorithmTimeMillis(int row, int column) {
        long start_time = System.currentTimeMillis();
        generate(row, column);
        long end_time = System.currentTimeMillis();
        return (end_time - start_time);
    }
}
