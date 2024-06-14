package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    public EmptyMazeGenerator() {}

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
