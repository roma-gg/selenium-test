package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class Selenium_DragAndDrop {
    WebDriver driver = Driver.getDriver();

    @Test
    public void dragAndDropTest() {
        driver.get(ConfigReader.getProperty("envDragAndDrop"));
        var leftSquare = driver.findElement(By.id("column-a"));
        var rightSquare = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();

        var leftHeader = driver.findElement(By.xpath("//div[@id='column-a']/header"));
        var rightHeader = driver.findElement(By.xpath("//div[@id='column-b']/header"));
        softAssert.assertEquals(leftHeader.getText(), "A", "default text failed");
        softAssert.assertEquals(rightHeader.getText(), "B", "default text failed");


        actions.dragAndDrop(leftSquare, rightSquare).perform();
        leftHeader = driver.findElement(By.xpath("//div[@id='column-a']/header"));
        rightHeader = driver.findElement(By.xpath("//div[@id='column-b']/header"));
        softAssert.assertEquals(leftHeader.getText(), "B", "second drag failed");
        softAssert.assertEquals(rightHeader.getText(), "A", "second drag failed");

        actions.dragAndDrop(rightSquare, leftSquare).perform();
        leftHeader = driver.findElement(By.xpath("//div[@id='column-a']/header"));
        rightHeader = driver.findElement(By.xpath("//div[@id='column-b']/header"));
        softAssert.assertEquals(leftHeader.getText(), "A", "third drag failed");
        softAssert.assertEquals(rightHeader.getText(), "B", "third drag failed");

        softAssert.assertAll();
    }
}
