package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Selenium_Dropdowns {
    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver = WebDriverFactory.getChromeDriver();
        driver.manage().window().maximize();
        WebDriverFactory.sync5sec(driver);
    }

    @BeforeMethod
    public void launchToDropdown() {
        driver.get("https://practice.cydeo.com/dropdown");
        WebDriverFactory.sync5sec(driver);
    }

    @Test
    public void checkDropBoxDisabled() {
        WebElement dropDownDefault = driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Please select an option']"));
        Assert.assertFalse(dropDownDefault.isEnabled());
    }

    @Test
    public void checkDropBoxSelected() {
        WebElement dropDownDefault = driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Please select an option']"));
        Assert.assertTrue(dropDownDefault.isSelected());
    }

    // to check if value mapped with text correctly and all 1924-2024 years are in the dropdown list;
    @Test
    public void yearsTextValueMatch() {
        List<WebElement> years = driver.findElements(By.xpath("//select[@id='year']/option"));

        Map<String, String> map = new HashMap<>();
        for (var year : years) {
            var text = year.getText();
            var value = year.getAttribute("value");
            map.put(text, value);
        }

        int oldestYear = 1924;
        int latestYear = 2024;
        SoftAssert softAssert = new SoftAssert();
        for (int i = oldestYear; i < latestYear; i++) {
            String year = String.valueOf(i);
            softAssert.assertTrue(map.containsKey(year) && map.get(year).equals(year));
            map.remove(year);
        }
        softAssert.assertAll();

        Assert.assertTrue(map.isEmpty());
    }

    // to check if the sequence of years in dropdown is correct;
    @Test
    public void yearsSequenceAndDuplicates() {
        List<WebElement> years = driver.findElements(By.xpath("//select[@id='year']/option"));
        var listOfYears = new ArrayList<String>();
        for (var year : years) {
            var text = year.getText();
            listOfYears.add(text);
        }

        var copyOfList = new ArrayList<String>(listOfYears);
        int oldestYear = 1924;
        int latestYear = 2023;

        SoftAssert softAssert = new SoftAssert();
        for (int i = latestYear, j = 0; i >= oldestYear; i--, j++) {
            String year = String.valueOf(i);
            softAssert.assertTrue(listOfYears.get(j).equals(year));
            copyOfList.remove(year);
        }
        softAssert.assertTrue(copyOfList.isEmpty());
        softAssert.assertAll();
    }

    @Test
    public void selectMyYearOfBith() {
        var year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1992");

        var month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("7");

        var day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("23");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(selectYear.getFirstSelectedOption().getAttribute("value").equals("1992"), "year check failed");
        softAssert.assertTrue(selectMonth.getFirstSelectedOption().getAttribute("value").equals("7"), "month check failed");
        softAssert.assertTrue(selectDay.getFirstSelectedOption().getAttribute("value").equals("23"), "day check failed");
        softAssert.assertAll();
    }

    @Test
    public void checkLinkDropdown() {
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("amazon"));
    }

    @Test
    public void checkAlert() throws InterruptedException {
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        WebDriverFactory.sync5sec(driver);

        SoftAssert softAssert = new SoftAssert();
        var alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        var message = driver.findElement(By.id("result"));
        softAssert.assertEquals(message.getText(), "You successfully clicked an alert");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        WebDriverFactory.sync5sec(driver);
        alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        softAssert.assertEquals(message.getText(), "You clicked: Ok");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        WebDriverFactory.sync5sec(driver);
        alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("Testing input");
        alert.accept();
        Assert.assertEquals(message.getText(), "You entered: Testing input");

        softAssert.assertAll();
    }

    @Test
    public void checkFrame() {
        driver.navigate().to("https://practice.cydeo.com/nested_frames");
        SoftAssert softAssert = new SoftAssert();

        driver.switchTo().frame(0);
        driver.switchTo().frame("frame-left");
        var actualFrameBodyText = driver.findElement(By.tagName("body")).getText();
        var expectedText = "LEFT";
        softAssert.assertEquals(actualFrameBodyText, expectedText);
        driver.switchTo().parentFrame();

        driver.switchTo().frame(1);
        actualFrameBodyText = driver.findElement(By.id("content")).getText();
        expectedText = "MIDDLE";
        softAssert.assertEquals(actualFrameBodyText, expectedText);
        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        actualFrameBodyText = driver.findElement(By.tagName("body")).getText();
        expectedText = "RIGHT";
        softAssert.assertEquals(actualFrameBodyText, expectedText);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        actualFrameBodyText = driver.findElement(By.tagName("body")).getText();
        expectedText = "BOTTOM";
        softAssert.assertEquals(actualFrameBodyText, expectedText);

        softAssert.assertAll();
    }

    @Test
    public void multipleWindows() {
        driver.navigate().to("https://practice.cydeo.com/windows");
        var newTabButton = driver.findElement(By.xpath("//div[@class='example']/a"));
        var mainWindow = driver.getWindowHandle();

        for (int i = 0; i < 3; i++) {
            newTabButton.click();
        }
        driver.close();

        SoftAssert softAssert = new SoftAssert();
        var newTabTitle = "New Window";
        var listOfWindows = driver.getWindowHandles();
        int i = 1;
        for (var window : listOfWindows) {
            driver.switchTo().window(window);
            WebDriverFactory.sync5sec(driver);
            var currentTitle = driver.getTitle();
            softAssert.assertEquals(currentTitle, newTabTitle, "Current tab: " + i++);
        }

        softAssert.assertAll();

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
