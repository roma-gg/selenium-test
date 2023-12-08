package com.cydeo.tests.shorts;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_FindByClassName {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement agreeCoockie = driver.findElement(By.id("L2AGLb"));
        agreeCoockie.click();
        Thread.sleep(1000);

        WebElement seachBox = driver.findElement(By.className("gLFyf"));
        seachBox.sendKeys("cydeo" + Keys.ENTER);

    }
}
