package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Selenium_Hover {

    WebDriver driver = Driver.getDriver();

    @Test
    public void hoverTest() {
        driver.get(ConfigReader.getProperty("envHovers"));
        var actions = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();

        var photo1 = driver.findElement(By.xpath("//div[@id='content']/div/div[1]/img"));
        actions.moveToElement(photo1).perform();
        var user1Name = driver.findElement(By.xpath("(//h5)[1]"));
        var user1Link = driver.findElement(By.xpath("//a[@href='/users/1']"));
        softAssert.assertTrue(user1Name.isDisplayed(), "user1Name failed");
        softAssert.assertTrue(user1Link.isDisplayed(), "user1Link failed");

        var photo2 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/img"));
        actions.moveToElement(photo2).perform();
        var user2Name = driver.findElement(By.xpath("(//h5)[2]"));
        var user2Link = driver.findElement(By.xpath("//a[@href='/users/2']"));
        softAssert.assertTrue(user2Name.isDisplayed(), "user2Name failed");
        softAssert.assertTrue(user2Link.isDisplayed(), "user2Link failed");

        var photo3 = driver.findElement(By.xpath("//div[@id='content']/div/div[3]/img"));
        actions.moveToElement(photo3).perform();
        var user3Name = driver.findElement(By.xpath("(//h5)[3]"));
        var user3Link = driver.findElement(By.xpath("//a[@href='/users/3']"));
        softAssert.assertTrue(user3Name.isDisplayed(), "user3Name failed");
        softAssert.assertTrue(user3Link.isDisplayed(), "user3Link failed");

        softAssert.assertAll();
    }
}
