package com.cydeo.tests.day04_hw;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day04_hw {
    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver = WebDriverFactory.getChromeDriver();
    }

    @Test
    public void locateAllElements() {
        driver.get("https://practice.cydeo.com/forgot_password");
        SoftAssert softAssert = new SoftAssert();

        var navLink = driver.findElement(By.cssSelector("a.nav-link"));
        softAssert.assertTrue(navLink.isDisplayed());

        var forgotPassHeader = driver.findElement(By.cssSelector("h2"));
        softAssert.assertTrue(forgotPassHeader.isDisplayed());

        var emailLabel = driver.findElement(By.cssSelector("div>label"));
        softAssert.assertTrue(emailLabel.isDisplayed());

        var emailInput = driver.findElement(By.cssSelector("div>input"));
        softAssert.assertTrue(emailInput.isDisplayed());

        var retrievePassButton = driver.findElement(By.cssSelector("button"));
        softAssert.assertTrue(retrievePassButton.isDisplayed());

        var poweredBy = driver.findElement(By.cssSelector("div[class='large-4 large-centered columns']>div"));
        softAssert.assertTrue(poweredBy.isDisplayed());
        var actualText = poweredBy.getText();
        var expectedText = "Powered by CYDEO";
        softAssert.assertEquals(actualText, expectedText);

        softAssert.assertAll();
    }

    @Test
    public void findAllLinks() {
        driver.get("https://practice.cydeo.com/abtest");
        var links = driver.findElements(By.tagName("a"));
        System.out.println("Links on page: " + links.size());
        System.out.println("Text of each link:");
        for (var link : links) {
            System.out.println("Text: " + link.getText() + ", href: " + link.getAttribute("href"));
        }
    }

    @Test
    public void checkBoxes() {
        driver.get("https://practice.cydeo.com/checkboxes");
        var checkBox1 = driver.findElement(By.id("box1"));
        var checkBox2 = driver.findElement(By.id("box2"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!checkBox1.isSelected());
        softAssert.assertTrue(checkBox2.isSelected());

        checkBox1.click();
        checkBox2.click();

        softAssert.assertTrue(checkBox1.isSelected());
        softAssert.assertTrue(!checkBox2.isSelected());

        softAssert.assertAll();
    }

    public void checkCydeoLink() {
        driver.get("https://practice.cydeo.com/abtest");
        SoftAssert softAssert = new SoftAssert();

        var cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));
        softAssert.assertTrue(cydeoLink.isDisplayed());

        driver.navigate().refresh();
        WebDriverFactory.sync5sec(driver);

        softAssert.assertTrue(cydeoLink.isDisplayed());

        softAssert.assertAll();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
