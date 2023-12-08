package com.cydeo.tests.day02_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HW3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("L2AGLb")).click();

        driver.findElement(By.linkText("Gmail")).click();
        Thread.sleep(1000);

        var actualTitle = driver.getTitle();
        var expectedTitleContent = "Gmail";
        if (actualTitle.contains(expectedTitleContent))
            System.out.println("GMAIL title verification: PASSED");
        else
            System.out.println("GMAIL title verification: FAILED");

        driver.navigate().back();
        Thread.sleep(1000);

        actualTitle = driver.getTitle();
        var expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle))
            System.out.println("GOOGLE title verification: PASSED");
        else
            System.out.println("GOOGLE title verification: FAILED");

        driver.quit();

    }
}
