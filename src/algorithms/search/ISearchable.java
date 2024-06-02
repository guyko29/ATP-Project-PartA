package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {

    ArrayList<AState> getAllPossibleStates(AState current_state);

    AState getStartState();

    AState getGoalState();
}
