package automation_practice;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC4 {
    WebDriver driver = Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyLogOut() {
        AP_Utility.login(driver, softAssert);
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        var actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Signup / Login"));
    }

}
