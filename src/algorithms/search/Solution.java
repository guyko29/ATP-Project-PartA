package algorithms.search;

import java.util.ArrayList;

public class Solution {
    private ArrayList<AState> path;

    public Solution() {
        this.path = new ArrayList<>();
    }

    public void addStateSolution(AState new_State) {
        this.path.add(0, new_State);
    }

    public ArrayList<AState> getSolutionPath() {
        return path;
    }
}
