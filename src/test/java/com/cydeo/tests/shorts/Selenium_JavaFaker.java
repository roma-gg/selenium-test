package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium_JavaFaker {
    WebDriver driver;
    @BeforeClass
    public void getDriver() {
        driver = WebDriverFactory.getChromeDriver();
    }

    @Test
    public void regForm() {
        driver.get("https://practice.cydeo.com/registration_form");

        var faker = new Faker();
        var firstName = faker.name().firstName();
        driver.findElement(By.name("firstname")).sendKeys(firstName);

        var lastName = faker.name().lastName();
        driver.findElement(By.name("lastname")).sendKeys(lastName);

        var userName = faker.name().username();
        driver.findElement(By.name("username")).sendKeys(userName);

        var phoneNumber = faker.numerify("773-###-####");
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
