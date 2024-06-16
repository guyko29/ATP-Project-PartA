package algorithms.search;

import algorithms.mazeGenerators.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The BestFirstSearchTest class contains unit tests for the BestFirstSearch algorithm.
 * It tests the performance and functionality of the algorithm with different types of mazes.
 */
class BestFirstSearchTest {
    BestFirstSearch bestFirstSearch = new BestFirstSearch();

    /**
     * Tests the time taken to solve a maze generated by MyMazeGenerator.
     * Asserts that the solving time is less than 60 seconds.
     * @throws Exception if an error occurs during maze generation or solving
     */
    @Test
    public void timeOfSolvingMyMaze() throws Exception {
        IMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(100, 100);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        long current_time_1 = System.currentTimeMillis();
        bestFirstSearch.solve(searchableMaze);
        long current_time_2 = System.currentTimeMillis();
        long total_time = current_time_2 - current_time_1;
        assertTrue(total_time < 60000);
    }

    /**
     * Tests the time taken to solve a maze generated by SimpleMazeGenerator.
     * Asserts that the solving time is less than 60 seconds.
     * @throws Exception if an error occurs during maze generation or solving
     */
    @Test
    public void timeOfSolvingSimpleMaze() throws Exception {
        IMazeGenerator mazeGenerator = new SimpleMazeGenerator();
        Maze maze = mazeGenerator.generate(100, 100);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        long current_time_1 = System.currentTimeMillis();
        bestFirstSearch.solve(searchableMaze);
        long current_time_2 = System.currentTimeMillis();
        long total_time = current_time_2 - current_time_1;
        assertTrue(total_time < 60000);
    }

    /**
     * Tests the time taken to solve a maze generated by EmptyMazeGenerator.
     * Asserts that the solving time is less than 60 seconds.
     * @throws Exception if an error occurs during maze generation or solving
     */
    @Test
    public void timeOfSolvingEmptyMaze() throws Exception {
        IMazeGenerator mazeGenerator = new EmptyMazeGenerator();
        Maze maze = mazeGenerator.generate(100, 100);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        long current_time_1 = System.currentTimeMillis();
        bestFirstSearch.solve(searchableMaze);
        long current_time_2 = System.currentTimeMillis();
        long total_time = current_time_2 - current_time_1;
        assertTrue(total_time < 60000);
    }

    /**
     * Tests the getName method of the BestFirstSearch algorithm.
     * Asserts that the name is "Best First Search".
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void getName() throws Exception {
        assertEquals("Best First Search", bestFirstSearch.getName());
    }

    /**
     * Tests the solve method with a null parameter.
     * Asserts that the result is not null.
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void nullParameter() throws Exception {
        assertNotNull(bestFirstSearch.solve(null));
    }
}
