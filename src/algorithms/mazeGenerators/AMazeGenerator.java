package algorithms.mazeGenerators;

public class AMazeGenerator implements IMazeGenerator{
    @Override
    public Maze generate(int row, int column) {
        return null;
    }

    @Override
    public long measureAlgorithmTimeMillis(int row, int column) {
        long start_time = System.currentTimeMillis();
        generate(row, column);
        long end_time = System.currentTimeMillis();
        return end_time - start_time;
    }
}
