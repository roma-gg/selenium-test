package com.cydeo.tests.day02_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HW4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/inputs");
        driver.manage().window().maximize();

        driver.findElement(By.className("nav-link")).click();

        var actualTitle = driver.getTitle();
        var expectedTitle = "Practice";
        if (actualTitle.equals(expectedTitle))
            System.out.println("Title verification: PASSED");
        else
            System.out.println("Title verification: FAILED");

        driver.quit();
    }
}
