package Server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Configurations {

    private static Configurations single_instance = null;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private Configurations() {}

    /**
     * Returns the singleton instance of the Configurations class.
     *
     * @return the Configurations instance
     */
    public static Configurations getInstance() {
        if (single_instance == null)
            single_instance = new Configurations();
        return single_instance;
    }

    /**
     * Changes the properties in the configuration file.
     * This method updates the configuration properties such as thread pool size,
     * maze generating algorithm, and maze searching algorithm.
     */
    public void changeProperties() {
        try (OutputStream output = new FileOutputStream("resources/config.properties")) {
            Properties prop = new Properties();
            prop.setProperty("threadPoolSize", "4");
            prop.setProperty("mazeGeneratingAlgorithm", "SimpleMazeGenerator");
            prop.setProperty("mazeSearchingAlgorithm", "BreadthFirstSearch");
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
