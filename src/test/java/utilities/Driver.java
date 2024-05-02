package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    } // Prevents instantiation of an object of this class from other classes using the new keyword.

    public static WebDriver getDriver() {

        if (driver == null) { // If driver is null (not created), create a new driver.

            String browser = ConfigReader.getProperty("browser"); // Returns the browser value written in the configuration.properties file as a String.

            switch (browser) { // Opens the respective browser based on the value retrieved from the configuration.properties file.

                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "headless":
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;
                default:
                    driver = new ChromeDriver();

            }

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }


    public static void closeDriver() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) { // If driver is not null (created), use the quit() method.
            driver.quit();
            driver = null; // Necessary for the getDriver() method to run again after the quit() operation.
        }

    }

}

/*
The used Driver Class returns a single static driver shared across all classes.
The Driver Class will allow us to use the same driver object across all classes in the framework.
When the Singleton Driver class is initialized, this Driver class repeatedly returns the same driver instance.

Singleton Pattern: Developed for singular usage, it's designed to have only one instance, Singleton Driver will force
the user to use the same object for all instances where WebDriver is required, that's why Singleton Pattern is used
to prevent instantiation of objects of a class in different classes.
The aim here is to prevent the use of the getDriver() method by instantiating objects in Driver class.

To create a Singleton class, we need to follow these steps:
The constructor created in the class should be private so that objects cannot be created in different classes.
There should be a static reference variable in the class; static is necessary to make it usable from anywhere.
A static method should be declared as the return type of the class object, which checks whether the class has been
initialized once or not.
 */
