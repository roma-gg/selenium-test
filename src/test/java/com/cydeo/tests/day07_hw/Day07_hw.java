package com.cydeo.tests.day07_hw;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Day07_hw {
    WebDriver driver = Driver.getDriver();



    @Test
    public void switchToEtsy() {
        driver.get(ConfigReader.getProperty("envAmazon"));
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        BrowserUtils.switchWindowAndVerify(driver, "amazon", "Amazon");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

}
