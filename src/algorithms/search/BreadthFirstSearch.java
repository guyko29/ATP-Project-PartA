package algorithms.search;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    protected Queue<AState> queue;

    public BreadthFirstSearch() {
        queue = new LinkedList<AState>();
        this.algorithm_name = "Breadth First Search";
    }

    @Override
    public String getName() {
        return algorithm_name;
    }

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
