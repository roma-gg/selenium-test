package com.cydeo.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_FindByTagName {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.tagName("title"));
        var result = header.getText();
        System.out.println(header.getText());


    }
}
