package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    @Override
    public long measureAlgorithmTimeMillis(int row, int column) {
        long start_time = System.currentTimeMillis();
        generate(row, column);
        long end_time = System.currentTimeMillis();
        return (end_time - start_time);
    }
}
