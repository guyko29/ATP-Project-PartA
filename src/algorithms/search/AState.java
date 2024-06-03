package algorithms.search;

public abstract class AState {
    private double cost;
    private boolean is_visited;
    private AState come_from;

    public AState() {
        this.is_visited = false;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void trueVisited() {
        this.is_visited = true;
    }

    public boolean isIs_visited() {
        return is_visited;
    }

    public void setIs_visited(boolean is_visited) {
        this.is_visited = is_visited;
    }

    public AState getCome_from() {
        return come_from;
    }

    public void setCome_from(AState come_from) {
        this.come_from = come_from;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) { return true; }
        if (object == null || this.getClass() != object.getClass()) { return false; }
        return false;
    }
}
