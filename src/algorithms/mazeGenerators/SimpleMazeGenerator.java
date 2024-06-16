package algorithms.mazeGenerators;

import java.util.Random;

/**
 * The SimpleMazeGenerator class generates a simple maze with random 0s and 1s.
 * It extends the abstract class AMazeGenerator.
 */
public class SimpleMazeGenerator extends AMazeGenerator {
    private final Random random = new Random();

    /**
     * Generates a simple maze with specified rows and columns.
     * The maze is randomly filled with 0s and 1s.
     * @param row the number of rows in the maze
     * @param column the number of columns in the maze
     * @return a Maze object with randomly filled cells
     */
    @Override
    public Maze generate(int row, int column) {
        Position start_pos = new Position(0, 0);
        Position goal_pos = new Position(row - 1, column - 1);
        Maze maze = new Maze(row, column, start_pos, goal_pos);
        int rand;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                rand = random.nextInt(0, 2);
                if (rand == 0) {
                    maze.setCellTo0(r, c);
                } else {
                    maze.setCellTo1(r, c);
                }
            }
        }
        maze.setCellTo0(0, 0);
        maze.setCellTo0(row - 1, column - 1);
        return maze;
    }
}
