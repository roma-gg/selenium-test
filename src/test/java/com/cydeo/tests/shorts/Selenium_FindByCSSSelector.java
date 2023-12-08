package com.cydeo.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium_FindByCSSSelector {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("L2AGLb")).click();
        List<WebElement> iAmLuckyButtons = driver.findElements(By.cssSelector("input.RNmpXc"));
        iAmLuckyButtons.get(1).click();



    }
}
