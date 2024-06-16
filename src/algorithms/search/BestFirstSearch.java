package algorithms.search;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The BestFirstSearch class implements the best-first search algorithm.
 * It extends the BreadthFirstSearch class and uses a priority queue to explore nodes based on cost.
 */
public class BestFirstSearch extends BreadthFirstSearch {

    /**
     * Constructs a BestFirstSearch algorithm with a priority queue.
     * Sets the algorithm name to "Best First Search".
     */
    public BestFirstSearch() {
        queue = new PriorityQueue<AState>(new ComparatorAState());
        this.algorithm_name = "Best First Search";
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
     * The ComparatorAState class implements a comparator for AState objects.
     * It compares states based on their cost.
     */
    public static class ComparatorAState implements Comparator<AState> {
        /**
         * Compares two AState objects based on their cost.
         * @param o1 the first state to compare
         * @param o2 the second state to compare
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
         */
        @Override
        public int compare(AState o1, AState o2) {
            return Double.compare(o1.getCost(), o2.getCost());
        }
    }
}
