package algorithms.search;

import java.util.ArrayList;

/**
 * The ISearchable interface defines methods for searching algorithms.
 * It provides methods to get possible states, start state, goal state,
 * restart the maze, and check if the goal state is reached.
 */
public interface ISearchable {

    /**
     * Gets all possible states from the current state.
     * @param current_state the current state
     * @return a list of all possible states
     */
    ArrayList<AState> getAllPossibleStates(AState current_state);

    /**
     * Gets the start state of the search problem.
     * @return the start state
     */
    AState getStartState();

    /**
     * Gets the goal state of the search problem.
     * @return the goal state
     */
    AState getGoalState();

    /**
     * Restarts the maze or search problem.
     */
    public void restartMaze();

    /**
     * Checks if the goal state is reached from the current state.
     * @param current_state the current state
     * @param goal_state the goal state
     * @return true if the goal state is reached, false otherwise
     */
    boolean isArrivedToGoal(AState current_state, AState goal_state);
}
