package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {
    Position current_position;

    public MazeState(Position current_position, String state_name) {
        super(state_name);
        this.current_position = current_position;
    }

    public Position getCurrent_position() {
        return current_position;
    }

    public void setCurrent_position(Position current_position) {
        this.current_position = current_position;
    }
}
