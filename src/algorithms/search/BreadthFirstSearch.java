package algorithms.search;

import Structures.Queue;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.Collection;
import java.util.Iterator;

public class BreadthFirstSearch {
    private Maze maze;

    public BreadthFirstSearch(Maze maze) {
        this.maze = maze;
    }

    public void BFS() {
        Queue queue = new Queue();
        queue.enqueue(maze.getStartPosition());
        Position c;
        while (!queue.isEmpty()) {
            c = queue.dequeue();
            if (c == maze.getGoalPosition()) { return; }
            else {

            }
        }
    }
}
