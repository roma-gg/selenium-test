package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Selenium_RightClick {
    WebDriver driver = Driver.getDriver();
    WebDriver driver2 = new ChromeDriver();
    RemoteWebDriver driver3 = new ChromeDriver();



    @Test
    public void rightClickTest() {
        driver.get("https://practice.cydeo.com/");
        var testLink = driver.findElement(By.xpath("//a[contains(text(), 'A/B')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(testLink).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                click().perform();

        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "No A/B Test");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
