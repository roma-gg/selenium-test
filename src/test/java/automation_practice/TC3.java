package automation_practice;

import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC3 {
    WebDriver driver = Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void logInWithInvalidCred() {
        Faker faker = new Faker();
        var email = faker.internet().emailAddress();
        var password = faker.internet().password();
        AP_Utility.login(driver, softAssert, email, password);

        var invalidCredMessage = driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']"));
        Assert.assertTrue(invalidCredMessage.isDisplayed());

    }

    @AfterClass
    public void closeDriver() {
        Driver.closeDriver();
    }

}
