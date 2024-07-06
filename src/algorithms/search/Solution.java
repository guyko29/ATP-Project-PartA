package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Solution class represents a solution to a search problem.
 * It contains a path of states from the start state to the goal state.
 */
public class Solution implements Serializable {
    private ArrayList<AState> path;

    /**
     * Constructs an empty Solution.
     */
    public Solution() {
        this.path = new ArrayList<>();
    }

    /**
     * Adds a new state to the solution path. The new state is added at the beginning of the path.
     * @param new_State the state to add
     */
    public void addStateSolution(AState new_State) {
        this.path.add(0, new_State);
    }

    /**
     * Gets the solution path.
     * @return the path of states from the start state to the goal state
     */
    public ArrayList<AState> getSolutionPath() {
        return path;
    }
}
