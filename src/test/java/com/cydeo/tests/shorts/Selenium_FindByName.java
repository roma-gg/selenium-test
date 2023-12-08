package com.cydeo.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_FindByName {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        WebElement agreeCoockie = driver.findElement(By.id("L2AGLb"));
        agreeCoockie.click();
        Thread.sleep(1000);

        WebElement seachBox = driver.findElement(By.name("q"));
        seachBox.sendKeys("amazon" + Keys.ENTER);

    }
}
