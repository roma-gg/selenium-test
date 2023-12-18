package automation_practice;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC5 {
    WebDriver driver = Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void registerExistingUserAndEmail() {
        driver.get("https://automationexercise.com");
        softAssert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed(), "main page is not loaded");

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        var signUpText = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        softAssert.assertTrue(signUpText.isDisplayed(), "signUpMessage is failed");

        var firstName = ConfigReader.getProperty("AP_validUserName");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstName);
        var email = ConfigReader.getProperty("AP_validEmail");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);
        driver.findElement(By.xpath("//button[.='Signup']")).click();

        var alreadyExistMessage = driver.findElement(By.xpath("//p[contains(., 'Email Address already exist!')]"));
        Assert.assertTrue(alreadyExistMessage.isDisplayed());
    }
}
