package algorithms.search;

/**
 * The AState class represents a state in a search algorithm.
 * It contains information about the cost, visited status, previous state, and state name.
 */
public abstract class AState {
    private double cost;
    private boolean is_visited;
    private AState come_from;
    private String state_name;

    /**
     * Constructs an AState with the specified state name.
     * @param state_name the name of the state
     */
    public AState(String state_name) {
        this.is_visited = false;
        this.state_name = state_name;
    }

    /**
     * Gets the cost associated with this state.
     * @return the cost of the state
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost associated with this state.
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Marks this state as visited.
     */
    public void trueVisited() {
        this.is_visited = true;
    }

    /**
     * Checks if this state has been visited.
     * @return true if the state has been visited, false otherwise
     */
    public boolean isIs_visited() {
        return is_visited;
    }

    /**
     * Sets the visited status of this state.
     * @param is_visited the visited status to set
     */
    public void setIs_visited(boolean is_visited) {
        this.is_visited = is_visited;
    }

    /**
     * Gets the name of this state.
     * @return the name of the state
     */
    public String getState_name() {
        return state_name;
    }

    /**
     * Gets the previous state from which this state was reached.
     * @return the previous state
     */
    public AState getCome_from() {
        return come_from;
    }

    /**
     * Sets the previous state from which this state was reached.
     * @param come_from the previous state to set
     */
    public void setCome_from(AState come_from) {
        this.come_from = come_from;
    }

    /**
     * Resets this state, clearing the previous state and setting visited status to false.
     */
    public void restartState() {
        come_from = null;
        is_visited = false;
    }

    /**
     * Returns a string representation of this state.
     * @return the name of the state
     */
    @Override
    public String toString() {
        return state_name;
    }

    /**
     * Checks if this state is equal to another object.
     * Two states are considered equal if their state names are equal.
     * @param object the object to compare with
     * @return true if the states are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AState state = (AState) object;
        return this.state_name != null ? this.state_name.equals(state.getState_name()) : state.getState_name() == null;
    }
}
