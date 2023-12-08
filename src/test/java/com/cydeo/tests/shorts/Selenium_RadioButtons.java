package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_RadioButtons {
    public static void main(String[] args) {
        var driver = WebDriverFactory.getDriver();
        driver.get("https://practice.cydeo.com/radio_buttons");
        WebDriverFactory.sync5sec(driver);

        var blueRadioButton = driver.findElement(By.xpath("//div[@class='radio']/input[@id='blue']"));
        if (blueRadioButton.isSelected())
            System.out.println("Blue button selected verification: PASSED");
        else
            System.out.println("Blue button selected verification: FAILED");

        var greenRadioButton = driver.findElement(By.xpath("//input[@id='green']"));
        if (!greenRadioButton.isEnabled())
            System.out.println("Green button disabled verification: PASSED");
        else
            System.out.println("Green button disabled verification: FAILED");

        var redRadioButton = driver.findElement(By.id("red"));
        System.out.println(redRadioButton.isSelected());
        redRadioButton.click();
        System.out.println(redRadioButton.isSelected());

    }
}
