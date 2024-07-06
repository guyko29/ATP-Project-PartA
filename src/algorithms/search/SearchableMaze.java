package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The SearchableMaze class adapts a Maze object to be used by search algorithms.
 * It implements the ISearchable interface and provides methods to get possible states,
 * start state, goal state, restart the maze, and check if the goal state is reached.
 */
public class SearchableMaze implements ISearchable, Serializable {
    private Maze maze;
    private AState[][] maze_state;

    /**
     * Constructs a SearchableMaze with the specified Maze object.
     * @param maze the maze to be searched
     */
    public SearchableMaze(Maze maze) {
        this.maze = maze;
        maze_state = new AState[maze.getRow()][maze.getColumn()];
        for (int r = 0; r < maze.getRow(); r++) {
            for (int c = 0; c < maze.getColumn(); c++) {
                AState state = new MazeState(new Position(r, c), " ");
                maze_state[r][c] = state;
            }
        }
    }

    /**
     * Gets all possible states from the current state.
     * @param current_state the current state
     * @return a list of all possible states
     */
    @Override
    public ArrayList<AState> getAllPossibleStates(AState current_state) {
        ArrayList<AState> all_possible_States = new ArrayList<>();
        MazeState current_state_maze = (MazeState) current_state;
        int state_row = current_state_maze.getCurrent_position().getRowIndex();
        int state_column = current_state_maze.getCurrent_position().getColumnIndex();
        int maze_row = maze.getRow();
        int maze_column = maze.getColumn();
        if (state_row + 1 < maze_row && maze.getCell(state_row + 1, state_column) == 0 && !maze_state[state_row + 1][state_column].isIs_visited()) {
            all_possible_States.add(maze_state[state_row + 1][state_column]);
            maze_state[state_row + 1][state_column].setCost(10);
        }
        if (state_column + 1 < maze_column && maze.getCell(state_row, state_column + 1) == 0 && !maze_state[state_row][state_column + 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row][state_column + 1]);
            maze_state[state_row][state_column + 1].setCost(10);
        }
        if (state_row - 1 >= 0 && maze.getCell(state_row - 1, state_column) == 0 && !maze_state[state_row - 1][state_column].isIs_visited()) {
            all_possible_States.add(maze_state[state_row - 1][state_column]);
            maze_state[state_row - 1][state_column].setCost(10);
        }
        if (state_column - 1 >= 0 && maze.getCell(state_row, state_column - 1) == 0 && !maze_state[state_row][state_column - 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row][state_column - 1]);
            maze_state[state_row][state_column - 1].setCost(10);
        }
        if ((state_row + 1 < maze_row && state_column + 1 < maze_column) && maze.getCell(state_row + 1, state_column + 1) == 0 && !maze_state[state_row + 1][state_column + 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row + 1][state_column + 1]);
            maze_state[state_row + 1][state_column + 1].setCost(15);
        }
        if ((state_row + 1 < maze_row && state_column - 1 >= 0) && maze.getCell(state_row + 1, state_column - 1) == 0 && !maze_state[state_row + 1][state_column - 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row + 1][state_column - 1]);
            maze_state[state_row + 1][state_column - 1].setCost(15);
        }
        if ((state_row - 1 >= 0 && state_column + 1 < maze_column) && maze.getCell(state_row - 1, state_column + 1) == 0 && !maze_state[state_row - 1][state_column + 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row - 1][state_column + 1]);
            maze_state[state_row - 1][state_column + 1].setCost(15);
        }
        if ((state_row - 1 >= 0 && state_column - 1 >= 0) && maze.getCell(state_row - 1, state_column - 1) == 0 && !maze_state[state_row - 1][state_column - 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row - 1][state_column - 1]);
            maze_state[state_row - 1][state_column - 1].setCost(15);
        }

        return all_possible_States;
    }

    /**
     * Gets the start state of the search problem.
     * @return the start state
     */
    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition(), "Start Position");
    }

    /**
     * Gets the goal state of the search problem.
     * @return the goal state
     */
    @Override
    public AState getGoalState() {
        return new MazeState(maze.getGoalPosition(), "Goal Position");
    }

    /**
     * Restarts the maze or search problem by resetting all states.
     */
    @Override
    public void restartMaze() {
        int rows = maze.getRow();
        int cols = maze.getColumn();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.maze_state[i][j].restartState();
            }
        }
    }

    /**
     * Checks if the goal state is reached from the current state.
     * @param current_state the current state
     * @param goal_state the goal state
     * @return true if the goal state is reached, false otherwise
     */
    @Override
    public boolean isArrivedToGoal(AState current_state, AState goal_state) {
        return current_state.equals(goal_state);
    }
}
