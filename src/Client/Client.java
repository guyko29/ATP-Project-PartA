package Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private InetAddress serverIP;
    private int serverPort;
    private IClientStrategy strategy;

    /**
     * Constructs a Client object with the specified server IP address, port number, and strategy.
     *
     * @param serverIP The IP address of the server.
     * @param serverPort The port number of the server.
     * @param strategy The strategy to handle client-server communication.
     */
    public Client(InetAddress serverIP, int serverPort, IClientStrategy strategy) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.strategy = strategy;
    }

    /**
     * Communicates with the server using the specified strategy.
     * Establishes a socket connection to the server and applies the client strategy to handle input and output streams.
     */
    public void communicateWithServer() {
        try {
            Socket serverSocket = new Socket(serverIP, serverPort);
            strategy.clientStrategy(serverSocket.getInputStream(), serverSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
