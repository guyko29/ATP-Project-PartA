package algorithms.search;

/**
 * The ISearchingAlgorithm interface defines methods for searching algorithms.
 * It provides methods to solve a search problem, get the algorithm's name,
 * and get the number of nodes evaluated during the search.
 */
public interface ISearchingAlgorithm {

    /**
     * Solves the given search problem.
     * @param searchable the search problem to solve
     * @return the solution to the search problem
     */
    Solution solve(ISearchable searchable);

    /**
     * Gets the name of the searching algorithm.
     * @return the name of the algorithm
     */
    String getName();

    /**
     * Gets the number of nodes evaluated during the search.
     * @return the number of nodes evaluated
     */
    int getNumberOfNodesEvaluated();
}
