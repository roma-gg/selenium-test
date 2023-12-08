package com.cydeo.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_FindByXPath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("L2AGLb")).click();

        //index of element
        WebElement iAmLuckyButton = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[2]"));

        //attribute of element
        WebElement iAmLuckyButton2 = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@value='Мені пощастить']"));

        iAmLuckyButton.click();

        driver.navigate().to("https://practice.cydeo.com/forgot_password");
        var emailForm = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/input"));
        emailForm.sendKeys("123@gmail.com" + Keys.ENTER);

        String emailSentConfirmation = driver.findElement(By.tagName("h4")).getText();
        if (emailSentConfirmation.equals("Your e-mail's been sent!"))
            System.out.println("Message verification: PASSED");
        else
            System.out.println("Message verification: FAILED");

        for (int i = 0; i < 3; i++) {
            driver.navigate().back();
        }

        var searchField = driver.findElement(By.xpath("//textarea[contains(@data-ved, Q39UDCAU)]"));
        searchField.sendKeys("amazon" + Keys.ENTER);




    }
}
