package com.cydeo.tests.day08_hw;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.CydeoPracticeUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;

public class Day08_hw {
    WebDriver driver = Driver.getDriver();

    @Test
    public void verifyTable() {
        driver.get("https://practice.cydeo.com/web-tables");
        CydeoPracticeUtils.orderVerify(driver, "Bob Martin", "12/31/2021");
    }

    @Test
    public void verifyTableEmail() {
        driver.get("https://practice.cydeo.com/tables");
        SoftAssert softAssert = new SoftAssert();

        var actualEmail = CydeoPracticeUtils.getTableGetEmail(driver, 2, "Jason");
        var expectedEmail = "jdoe@hotmail.com";
        softAssert.assertEquals(actualEmail, expectedEmail, "first test failed");

        actualEmail = CydeoPracticeUtils.getTableGetEmail(driver, 1, "Tim");
        expectedEmail = "tconway@earthlink.net";
        softAssert.assertEquals(actualEmail, expectedEmail, "second test failed");

        softAssert.assertAll();
    }

    @Test
    public void verifySearchTitle() {
        driver.get(ConfigReader.getProperty("envGoogle"));
        driver.findElement(By.cssSelector("div[class='QS5gu sy4vM']")).click();

        var searchKeyWord = ConfigReader.getProperty("searchKeyWord");
        driver.findElement(By.id("APjFqb")).sendKeys(searchKeyWord + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains(searchKeyWord));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
