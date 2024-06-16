package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * The MazeState class represents a state in the context of a maze.
 * It extends the abstract class AState and includes a position within the maze.
 */
public class MazeState extends AState {
    private Position current_position;

    /**
     * Constructs a MazeState with the specified position and state name.
     * @param current_position the position in the maze
     * @param state_name the name of the state
     */
    public MazeState(Position current_position, String state_name) {
        super(state_name);
        this.current_position = current_position;
    }

    /**
     * Gets the current position of this state in the maze.
     * @return the current position
     */
    public Position getCurrent_position() {
        return this.current_position;
    }

    /**
     * Checks if this MazeState is equal to another object.
     * Two MazeStates are considered equal if their positions are equal.
     * @param current_state the object to compare with
     * @return true if the MazeStates are equal, false otherwise
     */
    @Override
    public boolean equals(Object current_state) {
        MazeState current_maze_state = (MazeState) current_state;
        return this.current_position.equals(current_maze_state.getCurrent_position());
    }

    /**
     * Returns a string representation of this MazeState.
     * @return the position of the state as a string
     */
    @Override
    public String toString() {
        return "" + current_position + "";
    }
}
