package com.cydeo.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserUtils {

    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedTitle) {
        var tabsList = driver.getWindowHandles();
        for (String tab : tabsList) {
            if (driver.switchTo().window(tab).getCurrentUrl().contains(expectedInURL)) {
                Assert.assertTrue(driver.getTitle().contains(expectedTitle));
                break;
            }
        }
    }

    public static void verifyTitle (WebDriver driver, String expectedTitle) {
        var actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static void verifyTitleContains (WebDriver driver, String expectedInTitle) {
        var actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }




}
