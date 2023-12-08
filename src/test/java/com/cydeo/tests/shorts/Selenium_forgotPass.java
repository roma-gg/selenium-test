package com.cydeo.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_forgotPass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");
        Thread.sleep(1000);

        driver.findElement(By.linkText("Forgot Password")).click();
        var emailForm = driver.findElement(By.name("email"));
        emailForm.sendKeys("123@gmail.com");
        emailForm.submit();

        /*var confirmationMessage = driver.findElement(By.name("confirmation_message")).getText();*/
        var confirmationMessage = driver.findElement(By.xpath("//h4"));
        System.out.println(confirmationMessage.getAttribute("name"));
        System.out.println(confirmationMessage.getText().equals("Your e-mail's been sent!"));



    }
}
