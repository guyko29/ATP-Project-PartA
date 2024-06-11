package algorithms.search;

public abstract class AState {
    private double cost;
    private boolean is_visited;
    private AState come_from;

    private String state_name;

    public AState(String state_name) {
        this.is_visited = false;
        this.state_name = state_name;
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

    public String getState_name() {
        return state_name;
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
        AState new_Astate = (AState) object;
        return state_name != null ? state_name.equals(new_Astate.getState_name()) : new_Astate.state_name == null;
    }
}
