package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {
    Position current_position;

    public MazeState(Position current_position, String state_name) {
        super(state_name);
        this.current_position = current_position;
    }

    public Position getCurrent_position() {
        return this.current_position;
    }

    @Override
    public boolean equals (Object current_state){

        MazeState current_maze_state = (MazeState) current_state;
        return this.current_position.equals(current_maze_state.getCurrent_position());
    }

    @Override
    public String toString() {
        return "" + current_position + "";
    }
}