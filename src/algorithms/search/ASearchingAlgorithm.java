package algorithms.search;

import java.util.PriorityQueue;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int visited_state;
    protected PriorityQueue<AState> queue;
    protected String algorithm_name;

    public ASearchingAlgorithm() {
        this.queue = new PriorityQueue<AState>();
        this.visited_state = 0;
    }

    @Override
    public Solution solve(ISearchable searchable) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return visited_state;
    }

    public Solution createSolution(AState start_state, AState current_state, Solution solution) {
        while (!start_state.equals(current_state)) {
            solution.addStateSolution(current_state);
            current_state = current_state.getCome_from();
        }
        solution.addStateSolution(start_state);
        return solution;
    }
}
