package com.cydeo.tests.day02_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class Day2_HW1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://etsy.com");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();

        var searchQuery = driver.findElement(By.id("global-enhancements-search-query"));
        searchQuery.sendKeys("wooden spoon" + Keys.ENTER);

        var actualTitle = driver.findElement(By.tagName("title")).getText();
        var expectedTitle = "Wooden spoon - Etsy UK";

        if (actualTitle.equals(expectedTitle))
            System.out.println("Title verification: PASS");
        else
            System.out.println("Title verification: FAILED");


    }
}
