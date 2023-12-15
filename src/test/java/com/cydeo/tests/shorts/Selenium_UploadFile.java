package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.Driver;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_UploadFile {
    WebDriver driver = Driver.getDriver();

    @Test
    public void fileUploadTest() {
        driver.get(Properties.getPropertyValue("envUpload"));
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Roman\\Desktop\\Cover letter.docx");
        driver.findElement(By.id("file-submit")).click();
        var actualResult = driver.findElement(By.tagName("h3")).getText();
        var expectedResult = "File Uploaded!";
        Assert.assertEquals(expectedResult, actualResult);
    }

}
