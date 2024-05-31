package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int row, int column) {
        Maze maze = new Maze(row, column);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                maze.setCellTo0(r, c);
            }
        }
        maze.setStart_pos(0, 0);
        maze.setGoal_pos(row-1, column-1);
        return maze;
    }
}
