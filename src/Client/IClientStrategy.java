package Client;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface for defining the strategy to handle client-server communication.
 */
public interface IClientStrategy {

    /**
     * Defines the method to handle input and output streams between the client and the server.
     *
     * @param inFromServer The input stream from the server.
     * @param outToServer The output stream to the server.
     */
    void clientStrategy(InputStream inFromServer, OutputStream outToServer);
}
