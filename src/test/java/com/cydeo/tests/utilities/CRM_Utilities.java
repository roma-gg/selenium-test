package com.cydeo.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CRM_Utilities {

    public static void logIn_CRM(WebDriver driver) {
        driver.get("https://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys(ConfigReader.getProperty("nextBaseCRMLogin"));
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ConfigReader.getProperty("nextBaseCRMPass"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        BrowserUtils.verifyTitle(driver, "Portal");
    }

    public static void logIn_CRM(WebDriver driver, String username, String password) {
        driver.get("https://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        BrowserUtils.verifyTitle(driver, "Portal");
    }
}
