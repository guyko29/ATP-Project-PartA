package algorithms.search;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BestFirstSearch extends ASearchingAlgorithm {

    public BestFirstSearch() {
        queue = new PriorityQueue<AState>(new ComparatorAState());
        this.algorithm_name = "Best First Search";
    }

    @Override
    public String getName() {
        return algorithm_name;
    }

    public static class ComparatorAState implements Comparator<AState> {
        @Override
        public int compare(AState o1, AState o2) {
            return Double.compare(o1.getCost(), o2.getCost());
        }
    }
}
