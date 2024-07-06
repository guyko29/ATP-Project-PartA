package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private ExecutorService threadPool;

    /**
     * Initializes the Server with the specified port, listening interval, and strategy.
     * Configures the thread pool size from a properties file.
     *
     * @param port The port number on which the server will listen.
     * @param listeningIntervalMS The interval in milliseconds to wait for client connections.
     * @param strategy The strategy for handling client connections.
     */
    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        int total_threads = 3;
        try (InputStream input = new FileInputStream("resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            total_threads = Integer.valueOf(prop.getProperty("threadPoolSize"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.threadPool = Executors.newFixedThreadPool(total_threads);
    }

    /**
     * Starts the server in a new thread.
     */
    public void start() {
        new Thread(() -> {
            run();
        }).start();
    }

    /**
     * Main server loop that listens for client connections and handles them using a thread pool.
     */
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            serverSocket.setSoTimeout(this.listeningIntervalMS);
            while (!this.stop) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    this.threadPool.submit(() -> {
                        handleClient(clientSocket);
                    });
                } catch (SocketTimeoutException e) {
                    // Timeout exceptions are ignored to allow checking the stop flag.
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the client connection using the specified server strategy.
     *
     * @param clientSocket The client socket connection.
     */
    private void handleClient(Socket clientSocket) {
        try {
            this.strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stops the server by setting the stop flag to true.
     */
    public void stop() {
        this.stop = true;
    }
}
