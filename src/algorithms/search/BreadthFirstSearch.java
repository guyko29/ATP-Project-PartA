package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The BreadthFirstSearch class implements the breadth-first search algorithm.
 * It extends the abstract class ASearchingAlgorithm and uses a queue to explore nodes level by level.
 */
public class BreadthFirstSearch extends ASearchingAlgorithm {
    protected Queue<AState> queue;

    /**
     * Constructs a BreadthFirstSearch algorithm with an empty queue.
     * Sets the algorithm name to "Breadth First Search".
     */
    public BreadthFirstSearch() {
        queue = new LinkedList<AState>();
        this.algorithm_name = "Breadth First Search";
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
     * Solves the given search problem using breadth-first search.
     * @param searchable the search problem to solve
     * @return the solution to the search problem
     */
    @Override
    public Solution solve(ISearchable searchable) {
        if (searchable == null) { return new Solution(); }
        Solution solution = new Solution();
        AState start_state = searchable.getStartState();
        queue.add(start_state);
        while (!queue.isEmpty()) {
            AState current_state = queue.poll();
            visited_state++;
            current_state.trueVisited();
            if (searchable.isArrivedToGoal(current_state, searchable.getGoalState())) {
                Solution final_solution = createSolution(start_state, current_state, solution);
                searchable.restartMaze();
                return final_solution;
            }
            ArrayList<AState> neighbors_state = searchable.getAllPossibleStates(current_state);
            for (AState aState : neighbors_state) {
                if (!queue.contains(aState)) {
                    aState.setCome_from(current_state);
                    queue.add(aState);
                }
            }
        }
        searchable.restartMaze();
        return solution;
    }
}
