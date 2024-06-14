package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {
    private Stack<AState> stackState;

    public DepthFirstSearch() {
        stackState = new Stack<AState>();
        this.algorithm_name = "Depth First Search";
    }

    @Override
    public String getName() {
        return algorithm_name;
    }

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
