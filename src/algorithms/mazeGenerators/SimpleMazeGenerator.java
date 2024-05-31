package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    private final Random random = new Random();
    @Override
    public Maze generate(int row, int column) {
        Maze maze = new Maze(row, column);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                maze.setCellTo0(r, c);
            }
        }
        int numOfWalls = random.nextInt((int)(Math.sqrt(row * column) * 2)); // FIX
        int r, c;
        for (int w = 0; w < numOfWalls; w++) {
            r = random.nextInt(row);
            c = random.nextInt(column);
            maze.setCellTo1(r, c);
        }
        int start_r = random.nextInt(row);
        int start_c = random.nextInt(column);
        maze.setStart_pos(start_r, start_c);
        int end_r = random.nextInt(row);
        int end_c = random.nextInt(column);
        maze.setGoal_pos(end_r, end_c);

        return maze;
    }
}
