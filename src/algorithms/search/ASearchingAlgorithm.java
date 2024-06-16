package algorithms.search;

import java.util.PriorityQueue;

/**
 * The ASearchingAlgorithm class is an abstract class that implements common functionality for searching algorithms.
 * It implements the ISearchingAlgorithm interface and provides basic operations such as popping from a queue,
 * creating solutions, and counting visited states.
 */
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int visited_state;
    protected PriorityQueue<AState> queue;
    protected String algorithm_name;

    /**
     * Constructs an ASearchingAlgorithm with an empty priority queue and zero visited states.
     */
    public ASearchingAlgorithm() {
        this.queue = new PriorityQueue<>();
        this.visited_state = 0;
    }

    /**
     * Pops the top element from the priority queue.
     * @return the top element of the queue
     */
    public AState queuePop() {
        visited_state++;
        return queue.poll();
    }

    /**
     * Solves the given search problem. This method should be implemented by subclasses.
     * @param searchable the search problem to solve
     * @return the solution to the search problem
     */
    @Override
    public Solution solve(ISearchable searchable) {
        return null;
    }

    /**
     * Gets the name of the searching algorithm. This method should be implemented by subclasses.
     * @return the name of the algorithm
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * Gets the number of nodes evaluated during the search.
     * @return the number of nodes evaluated
     */
    @Override
    public int getNumberOfNodesEvaluated() {
        return visited_state;
    }

    /**
     * Creates a solution by tracing back from the current state to the start state.
     * @param start_state the starting state of the search
     * @param current_state the current state of the search
     * @param solution the solution object to populate
     * @return the populated solution object
     */
    public Solution createSolution(AState start_state, AState current_state, Solution solution) {
        while (!start_state.equals(current_state)) {
            solution.addStateSolution(current_state);
            current_state = current_state.getCome_from();
        }
        if (start_state.equals(current_state)) {
            solution.addStateSolution(start_state);
        }
        return solution;
    }
}
