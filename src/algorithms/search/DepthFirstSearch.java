package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * The DepthFirstSearch class implements the depth-first search algorithm.
 * It extends the abstract class ASearchingAlgorithm and uses a stack to explore nodes depth-first.
 */
public class DepthFirstSearch extends ASearchingAlgorithm {
    private Stack<AState> stackState;

    /**
     * Constructs a DepthFirstSearch algorithm with an empty stack.
     * Sets the algorithm name to "Depth First Search".
     */
    public DepthFirstSearch() {
        stackState = new Stack<AState>();
        this.algorithm_name = "Depth First Search";
    }

    /**
     * Gets the name of the searching algorithm.
     * @return the name of the algorithm
     */
    @Override
    public String getName() {
        return algorithm_name;
    }

    /**
     * Solves the given search problem using depth-first search.
     * @param searchable the search problem to solve
     * @return the solution to the search problem
     */
    @Override
    public Solution solve(ISearchable searchable) {
        if (searchable == null) { return new Solution(); }
        Solution solution = new Solution();
        HashSet<AState> hashSetState = new HashSet<>();
        AState start_state = searchable.getStartState();
        stackState.push(start_state);
        while (!stackState.isEmpty()) {
            AState current_state = stackState.pop();
            visited_state++;
            current_state.trueVisited();
            if (searchable.isArrivedToGoal(current_state, searchable.getGoalState())) {
                Solution final_solution = createSolution(start_state, current_state, solution);
                searchable.restartMaze();
                return final_solution;
            }
            ArrayList<AState> neighbors_state = searchable.getAllPossibleStates(current_state);
            for (AState neighbor : neighbors_state) {
                if (!hashSetState.contains(neighbor) && !stackState.contains(neighbor)) {
                    stackState.push(neighbor);
                    neighbor.setCome_from(current_state);
                }
            }
            hashSetState.add(current_state);
        }
        searchable.restartMaze();
        return solution;
    }
}
