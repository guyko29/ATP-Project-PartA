package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    private Maze maze;
    private AState[][] maze_state;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
        maze_state = new AState[maze.getRow()][maze.getColumn()];
        for (int r = 0; r < maze.getRow(); r++) {
            for (int c = 0; c < maze.getColumn(); c++) {
                AState state = new MazeState(new Position(r, c), " ");
                maze_state[r][c] = state;
            }
        }
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState current_state) {
        ArrayList<AState> all_possible_States = new ArrayList<>();
        MazeState current_state_maze = (MazeState) current_state;
        int state_row = current_state_maze.getCurrent_position().getRowIndex();
        int state_column = current_state_maze.getCurrent_position().getColumnIndex();
        int maze_row = maze.getRow();
        int maze_column = maze.getColumn();
        if (state_row + 1 < maze_row && state_row + 1 < maze_row && maze.getCell(state_row + 1, state_column) == 0 && !maze_state[state_row + 1][state_column].isIs_visited()) {
            all_possible_States.add(maze_state[state_row + 1][state_column]);
            maze_state[state_row + 1][state_column].setCost(10);
        }
        if (state_column + 1 < maze_column && state_column + 1 < maze_column && maze.getCell(state_row, state_column + 1) == 0 && !maze_state[state_row][state_column + 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row][state_column + 1]);
            maze_state[state_row][state_column + 1].setCost(10);
        }
        if (state_row - 1 >= 0 && state_row - 1 < maze_row && maze.getCell(state_row - 1, state_column) == 0 && !maze_state[state_row - 1][state_column].isIs_visited()) {
            all_possible_States.add(maze_state[state_row - 1][state_column]);
            maze_state[state_row - 1][state_column].setCost(10);
        }
        if (state_column - 1 >= 0 && state_column - 1 < maze_column && maze.getCell(state_row, state_column - 1) == 0 && !maze_state[state_row][state_column - 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row][state_column - 1]);
            maze_state[state_row][state_column - 1].setCost(10);
        }

        if ((state_row + 1 < maze_row && state_column + 1 < maze_column) && maze.getCell(state_row + 1, state_column + 1) == 0 && !maze_state[state_row + 1][state_column + 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row + 1][state_column + 1]);
            maze_state[state_row + 1][state_column + 1].setCost(15);
        }
        if ((state_row + 1 < maze_row && state_column - 1 >= 0) && maze.getCell(state_row + 1, state_column - 1) == 0 && !maze_state[state_row + 1][state_column - 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row + 1][state_column - 1]);
            maze_state[state_row + 1][state_column - 1].setCost(15);
        }
        if ((state_row - 1 >= 0 && state_column + 1 < maze_column) && maze.getCell(state_row - 1, state_column + 1) == 0 && !maze_state[state_row - 1][state_column + 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row - 1][state_column + 1]);
            maze_state[state_row - 1][state_column + 1].setCost(15);
        }
        if ((state_row - 1 >= 0 && state_column - 1 >= 0) && maze.getCell(state_row - 1, state_column - 1) == 0 && !maze_state[state_row - 1][state_column - 1].isIs_visited()) {
            all_possible_States.add(maze_state[state_row - 1][state_column - 1]);
            maze_state[state_row - 1][state_column - 1].setCost(15);
        }

        return all_possible_States;
    }

    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition(), "Start Position");
    }

    @Override
    public AState getGoalState() {
        return new MazeState(maze.getGoalPosition(), "Goal Position");
    }
}
