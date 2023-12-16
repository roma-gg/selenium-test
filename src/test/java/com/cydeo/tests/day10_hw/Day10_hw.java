package com.cydeo.tests.day10_hw;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;

public class Day10_hw {
    WebDriver driver = Driver.getDriver();

    @Test
    public void verifyRegistration() {
        driver.get("https://practice.cydeo.com/registration_form");
        Faker faker = new Faker();

        var firstName = faker.name().firstName();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);

        var lastName = faker.name().lastName();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);

        var userName = faker.letterify("??????????????");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

        var email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        var password = faker.internet().password();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        var phone = faker.numerify("###-###-####");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);

        driver.findElement(By.xpath("//input[@value='male']")).click();

        var simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        var dateOfBirth = simpleDateFormat.format(faker.date().birthday());
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys(dateOfBirth);

        var department = driver.findElement(By.xpath("//select[@name='department']"));
        var select = new Select(department);
        select.selectByValue("DA");

        var jobTitle = driver.findElement(By.xpath("//select[@name='job_title']"));
        select = new Select(jobTitle);
        select.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        var actualMessage = driver.findElement(By.tagName("p")).getText();
        var expectedMessage = "You've successfully completed registration!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void uploadTest() {
        driver.get("https://practice.cydeo.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Roman\\Desktop\\Passport Oleksandra\\Screenshot_1.jpg");
        driver.findElement(By.id("file-submit")).click();

        var actualMessage = driver.findElement(By.tagName("h3")).getText();
        var expectedMessage = "File Uploaded!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void hoverTest() {
        driver.get(ConfigReader.getProperty("envHovers"));
        var listOfImages = driver.findElements(By.tagName("img"));

        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(driver);

        int num = 1;
        for (WebElement image : listOfImages) {
            actions.moveToElement(image).perform();
            var text = driver.findElement(By.xpath("//h5[text()='name: user" + num++ + "']"));
            softAssert.assertTrue(text.isDisplayed());
        }

        softAssert.assertAll();
    }

    @Test
    public void scrollTest() {
        driver.get(ConfigReader.getProperty("envMain"));
        var cydeoLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(cydeoLink).perform();
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
    }

    @Test
    public void infiniteScrollTest() {
        driver.get("https://practice.cydeo.com/infinite_scroll");
        var jse = (JavascriptExecutor)Driver.getDriver();
        BrowserUtils.sleep(3);
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            jse.executeScript("window.scrollBy(0, 750)");
        }

        for (int i = 0; i < 3; i++) {
            jse.executeScript("window.scrollBy(0, -750)");
        }
    }

    @Test
    public void nestedDOMScrollTest() {
        driver.get("https://practice.cydeo.com/large");
        var jse = (JavascriptExecutor)Driver.getDriver();
        var cydeoLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        var homeLink = driver.findElement(By.xpath("//a[text()='Home']"));

        BrowserUtils.sleep(1);
        jse.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
        BrowserUtils.sleep(1);
        jse.executeScript("arguments[0].scrollIntoView(true)", homeLink);
    }
}
