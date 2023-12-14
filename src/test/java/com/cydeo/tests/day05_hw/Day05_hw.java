package com.cydeo.tests.day05_hw;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class Day05_hw extends TestBase {

    @Test
    public void addRemoveElements() {
        driver.get(ConfigReader.getProperty("envAddAndRemoveElements"));
        WebDriverFactory.sync5sec(driver);

        var addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();
        WebDriverFactory.sync5sec(driver);

        SoftAssert softAssert = new SoftAssert();
        var deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        softAssert.assertTrue(deleteButton.isDisplayed());

        deleteButton.click();

        try {
            softAssert.assertTrue(!deleteButton.isDisplayed());
        }
        catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caused by removing of the web element");
        }

        softAssert.assertAll();
    }

    @Test
    public void radioButton() {
        driver.get(ConfigReader.getProperty("envRadioButtons"));
        WebDriverFactory.sync5sec(driver);

        var hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();
        Assert.assertTrue(hockeyButton.isSelected());
    }

    @Test
    public void simpleDropdown() {
        driver.get(ConfigReader.getProperty("envDropDown"));
        var dropDownDefaultOptionText = driver.findElement(By.xpath("//select[@id='dropdown']/option[@selected='selected']")).getText();
        var expectedText = "Please select an option";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dropDownDefaultOptionText, expectedText);

        var stateSelectDefaultOption = driver.findElement(By.xpath("//select[@id='state']/option[@selected='selected']")).getText();
        expectedText = "Select a State";
        softAssert.assertEquals(stateSelectDefaultOption, expectedText);

        softAssert.assertAll();
    }

    @Test
    public void selectDate() {
        driver.get(ConfigReader.getProperty("envDropDown"));
        SoftAssert softAssert = new SoftAssert();

        var year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1933");
        softAssert.assertTrue(driver.findElement(By.cssSelector("option[value='1933']")).isSelected(), "Year failed");

        var month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("11");
        softAssert.assertTrue(driver.findElement(By.xpath("//select[@id='month']/option[@value='11']")).isSelected(), "Month failed");

        var day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(0);
        softAssert.assertTrue(driver.findElement(By.xpath("//select[@id='day']/option[@value='1']")).isSelected(), "Day failed");

        softAssert.assertAll();
    }

    @Test
    public void stateDropdown() throws InterruptedException {
        driver.get(ConfigReader.getProperty("envDropDown"));
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByVisibleText("Illinois");
        select.selectByValue("VA");
        select.selectByIndex(5);

        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='state']/option[@value='CA']")).isSelected());
    }

    @Test
    public void linkDropDown() {
        driver.get(ConfigReader.getProperty("envDropDown"));
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Facebook')]")).click();
        WebDriverFactory.sync5sec(driver);

        driver.findElement(By.xpath("//div[@class='_al64']/button[2]")).click();
        Assert.assertTrue(driver.getTitle().contains("Facebook"));
    }
}
