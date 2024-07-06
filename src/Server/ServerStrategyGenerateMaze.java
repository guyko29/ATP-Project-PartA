package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.*;

import java.io.*;
import java.nio.channels.Channels;
import java.util.Properties;

public class ServerStrategyGenerateMaze implements IServerStrategy {

    /**
     * Implements the server strategy for generating a maze based on client requests.
     * The generated maze is sent back to the client.
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
            int[] rows_columns_maze = (int[]) fromClient.readObject();
            int rows = rows_columns_maze[0];
            int columns = rows_columns_maze[1];
            String generator_name = "";
            try (InputStream input = new FileInputStream("resources/config.properties")) {
                Properties prop = new Properties();
                prop.load(input);
                generator_name = prop.getProperty("mazeGeneratingAlgorithm");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            new MyMazeGenerator();
            AMazeGenerator maze_generator = switch (generator_name.toLowerCase()) {
                case "simplemazegenerator" -> new MyMazeGenerator();
                case "mymazegenerator" -> new SimpleMazeGenerator();
                case "emptymazegenerator" -> new EmptyMazeGenerator();
                default -> new MyMazeGenerator();
            };
            Maze new_maze = maze_generator.generate(rows, columns);
            byte[] array_of_new_maze = new_maze.toByteArray();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MyCompressorOutputStream my_compress = new MyCompressorOutputStream(byteArrayOutputStream);
            my_compress.write(array_of_new_maze);
            toClient.writeObject(byteArrayOutputStream.toByteArray());
            toClient.flush();
            fromClient.close();
            toClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
