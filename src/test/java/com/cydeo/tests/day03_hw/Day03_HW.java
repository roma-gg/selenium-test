package com.cydeo.tests.day03_hw;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day03_HW {
    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver = WebDriverFactory.getChromeDriver();
    }

    @BeforeMethod
    public void getPage() {
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void incorrectLogin() {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("incorrect");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("incorrect");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        var errorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        var expectedErrorMessage = "Incorrect login or password";
        Assert.assertEquals(errorMessage, expectedErrorMessage);
    }

    @Test
    public void forgotAndRemember() {
        SoftAssert softAssert = new SoftAssert();

        var actualText = driver.findElement(By.xpath("//label[@class='login-item-checkbox-label']")).getText();
        var expectedText = "Remember me on this computer";
        softAssert.assertEquals(actualText, expectedText, "Remember me verification");

        WebElement forgotMeLink = driver.findElement(By.className("login-link-forgot-pass"));
        actualText =  forgotMeLink.getText();
        expectedText = "FORGOT YOUR PASSWORD?";
        softAssert.assertEquals(actualText, expectedText, "Forgot password verification");

        var actualLink = forgotMeLink.getAttribute("href");
        var expectedPartialLink = "forgot_password=yes";
        softAssert.assertTrue(actualLink.contains(expectedPartialLink));

        softAssert.assertAll();
    }

    @Test
    public void logInButton() {
        var actualText = driver.findElement(By.className("login-btn")).getAttribute("value");
        var expectedText = "Log In";
        Assert.assertEquals(expectedText, actualText);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
