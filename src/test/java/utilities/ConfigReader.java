package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties; // Creating a Properties object to store configuration data.

    static {
        String filePath = "configuration.properties"; // Specifying the path of the configuration file.
        try {
            FileInputStream fis = new FileInputStream(filePath); // Creating a FileInputStream for reading the file.
            properties = new Properties(); // Creating a new Properties object to store configuration data.
            properties.load(fis); // Loading the data read by FileInputStream into the Properties object.
            fis.close(); // Closing the file.
        } catch (IOException e) {
            e.printStackTrace(); // Catching exceptions and printing them to the console in case of errors.
        }
    }

    public static String getProperty(String key) {
        // Creating a getProperty method that returns the value associated with the specified key.
        return properties.getProperty(key);
    }
}
