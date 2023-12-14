package com.cydeo.tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigReader.getProperty("browser");
            if (browserType.equalsIgnoreCase("chrome"))
                driver = new ChromeDriver();
            else if (browserType.equalsIgnoreCase("firefox"))
                driver = new FirefoxDriver();
            else if (browserType.equalsIgnoreCase("edge"))
                driver = new EdgeDriver();
            else
                throw new IllegalArgumentException();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
