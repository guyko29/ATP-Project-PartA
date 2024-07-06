package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface for defining the strategy to handle client-server communication.
 */
public interface IServerStrategy {

    /**
     * Defines the method to handle input and output streams between the server and the client.
     *
     * @param inFromClient The input stream from the client.
     * @param outToClient The output stream to the client.
     * @throws IOException If an I/O error occurs while handling the streams.
     */
    void ServerStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException;
}