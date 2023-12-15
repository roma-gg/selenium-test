package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_JavaExecutor {
    WebDriver driver = Driver.getDriver();
    JavascriptExecutor JSdriver = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void JSE_ScrollingTest() {
        driver.get(ConfigReader.getProperty("envMain"));
        var cydeoLink = driver.findElement(By.xpath("//a[contains(text(), 'CYDEO')]"));
        JSdriver.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
    }
}
