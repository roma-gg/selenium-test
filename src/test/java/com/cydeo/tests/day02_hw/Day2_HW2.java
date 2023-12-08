package com.cydeo.tests.day02_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HW2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.manage().window().maximize();

        var actualHeader = driver.findElement(By.tagName("h3")).getText();
        var expectedHeader = "Log in to ZeroBank";

        if (actualHeader.equals(expectedHeader))
            System.out.println("Header verification: PASSED");
        else
            System.out.println("Header verification: FAILED");

        driver.quit();
    }
}
