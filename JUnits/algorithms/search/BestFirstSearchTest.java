package algorithms.search;

import algorithms.mazeGenerators.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {
    BestFirstSearch bestFirstSearch = new BestFirstSearch();

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

    @Test
    public void getName() throws Exception {
        assertEquals("Best First Search", bestFirstSearch.getName());
    }

    @Test
    public void nullParameter() throws Exception {
        assertNotNull(bestFirstSearch.solve(null));
    }
}