package com.cydeo.tests.day06_hw;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class Day06_hw {
    WebDriver driver;
    @BeforeClass
    public void getDriver() {
        driver = WebDriverFactory.getChromeDriver();
    }
}
