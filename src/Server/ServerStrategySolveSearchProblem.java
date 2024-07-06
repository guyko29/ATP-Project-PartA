package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.*;

import java.io.*;
import java.nio.channels.Channels;
import java.util.Properties;

public class ServerStrategySolveSearchProblem implements IServerStrategy{

    /**
     * Implements the server strategy for solving a maze search problem based on client requests.
     * The solved maze solution is sent back to the client.
     *
     * @param inFromClient  the input stream from the client
     * @param outToClient   the output stream to the client
     * @throws IOException  if an I/O error occurs
     */
    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException {
        try {
            InputStream interruptibleInputStream = Channels.newInputStream(Channels.newChannel(inFromClient));
            ObjectInputStream fromClient = new ObjectInputStream(interruptibleInputStream);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            Maze maze_from_client = (Maze) fromClient.readObject();
            String mazeName = maze_from_client.getMazeDetails();
            String solutionFilePath = getSolutionFilePath(mazeName);
            File file = new File(solutionFilePath);
            if (file.exists()){
                Solution existingSolution = readSolutionFromFile(file);
                toClient.writeObject(existingSolution);
                toClient.flush();
                fromClient.close();
                toClient.close();
            } else {
                String searching_name = "";
                try (InputStream input = new FileInputStream("resources/config.properties")) {
                    Properties prop = new Properties();
                    prop.load(input);
                    searching_name = prop.getProperty("mazeSearchingAlgorithm");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                SearchableMaze searchable_maze = new SearchableMaze(maze_from_client);
                new BreadthFirstSearch();
                ISearchingAlgorithm searchingAlgorithm = switch (searching_name.toLowerCase()) {
                    case "breadthfirstsearch" -> new BreadthFirstSearch();
                    case "bestfirstsearch" -> new BestFirstSearch();
                    case "depthfirstsearch" -> new DepthFirstSearch();
                    default -> new BreadthFirstSearch();
                };
                Solution maze_solution = searchingAlgorithm.solve(searchable_maze);
                ObjectOutputStream solution_output =  new ObjectOutputStream(new FileOutputStream(file));
                solution_output.writeObject(maze_solution);
                toClient.writeObject(maze_solution);
                toClient.flush();
                fromClient.close();
                toClient.close();
            }

        } catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }


    /**
     * Generates the file path for storing the solution based on the maze name.
     *
     * @param mazeName  the name of the maze
     * @return the file path for storing the solution
     */
    private String getSolutionFilePath(String mazeName) {
        String tempDirectoryPath = System.getProperty("java.io.tmpdir");
        String sanitizedMazeName = mazeName.replaceAll("[^a-zA-Z0-9-_\\.]", "_"); // Replace invalid characters with underscores
        int hashCode = sanitizedMazeName.hashCode(); // Get the hash code of the sanitized maze name
        return tempDirectoryPath + hashCode;
    }


    private Solution readSolutionFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (Solution) inputStream.readObject();
        }
    }

}
