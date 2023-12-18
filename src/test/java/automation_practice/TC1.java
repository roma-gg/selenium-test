package automation_practice;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC1 {

    WebDriver driver = Driver.getDriver();

    //code can be refactored, but in this case it will be exactly like TC2, so I decide to leave it as it is.
    @Test
    public void test_case1() {
        driver.get("https://automationexercise.com/");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed(), "main page is not loaded");

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        var signUpText = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        softAssert.assertTrue(signUpText.isDisplayed(), "signUpMessage is failed");

        Faker faker = new Faker();
        var firstName = faker.name().firstName();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstName);

        var email = faker.internet().emailAddress();
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);

        driver.findElement(By.xpath("//button[.='Signup']")).click();
        var actualText = driver.findElement(By.xpath("//h2/b")).getText();
        var expectedText = "ENTER ACCOUNT INFORMATION";
        softAssert.assertEquals(actualText, expectedText);

        driver.findElement(By.id("id_gender1")).click();

        var password = faker.internet().password();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("first_name")).sendKeys(firstName);

        var lastName = faker.name().lastName();
        driver.findElement(By.id("last_name")).sendKeys(lastName);

        var company = faker.company().name();
        driver.findElement(By.id("company")).sendKeys(company);

        var address1 = faker.address().fullAddress();
        driver.findElement(By.id("address1")).sendKeys(address1);

        var zipCode = faker.address().zipCode();
        driver.findElement(By.id("address2")).sendKeys(zipCode);

        Select country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        country.selectByValue("United States");

        var state = faker.address().state();
        driver.findElement(By.id("state")).sendKeys(state);

        var city = faker.address().city();
        driver.findElement(By.id("city")).sendKeys(city);

        driver.findElement(By.id("zipcode")).sendKeys(zipCode);

        var phoneNumber = faker.phoneNumber().phoneNumber();
        driver.findElement(By.id("mobile_number")).sendKeys(phoneNumber);

        driver.findElement(By.xpath("//button[.='Create Account']")).click();

        actualText = driver.findElement(By.xpath("//b[contains(text(), 'Account')]")).getText();
        expectedText = "ACCOUNT CREATED!";
        softAssert.assertEquals(actualText, expectedText);

        driver.findElement(By.xpath("//a[.='Continue']")).click();

        actualText = driver.findElement(By.xpath("//a[contains(text(), ' Logged in as ')]")).getText();
        expectedText = "Logged in as " + firstName;
        softAssert.assertEquals(actualText, expectedText);

        driver.findElement(By.xpath("//a[contains(@href, 'delete')]")).click();
        actualText = driver.findElement(By.tagName("h2")).getText();
        expectedText = "ACCOUNT DELETED!";
        softAssert.assertEquals(actualText, expectedText);

        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver() {
        Driver.closeDriver();
    }
}
