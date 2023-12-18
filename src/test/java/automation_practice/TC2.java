package automation_practice;

import com.cydeo.tests.utilities.ConfigReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC2 {

    WebDriver driver = Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test_case2() {
        AP_Utility.createNewAccountAndLogOut(driver, softAssert);

        var tempEmail = ConfigReader.getProperty("TEMP_VALID_EMAIL");
        var tempPassword = ConfigReader.getProperty("TEMP_VALID_PASSWORD");
        AP_Utility.login(driver, softAssert, tempEmail, tempPassword);

        var userName = ConfigReader.getProperty("TEMP_VALID_USER");
        var loggedStatus = driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).getText();

        softAssert.assertTrue(loggedStatus.contains(userName));

        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        var actualDeletion = driver.findElement(By.tagName("h2")).getText();
        var expectedDeletion = "ACCOUNT DELETED!";
        softAssert.assertEquals(actualDeletion, expectedDeletion);

        softAssert.assertAll();
    }

    @AfterClass
    public void closeDriver() {
        Driver.closeDriver();
    }
}
