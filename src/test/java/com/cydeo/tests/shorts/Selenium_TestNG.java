package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Selenium_TestNG {

    /*WebDriver driver;
    @BeforeClass
    public void getDriver() {
        driver = WebDriverFactory.getDriver();
    }*/

    @Test (priority = 2)
    public void testMath() {
        System.out.println("test1 is running");
        Assert.assertEquals(5+3, 8);
    }

    @Test(priority = 1)
    public void testMath2() {
        System.out.println("test2 is running");
        Assert.assertTrue(7 == 5+2);
    }

    @Test
    public void softAssortion() {
        var soft = new SoftAssert();
        soft.assertEquals(2, 1+1);
        System.out.println("soft assertion");
        soft.assertAll("wulala");
    }

    @Test
    public void hardAssortion() {
        Assert.assertEquals(2, 1+1);
        System.out.println("hard assertion");
    }
}
