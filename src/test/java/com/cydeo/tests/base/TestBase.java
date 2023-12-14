package com.cydeo.tests.base;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = WebDriverFactory.getDriver(ConfigReader.getProperty("browser"));
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

}
