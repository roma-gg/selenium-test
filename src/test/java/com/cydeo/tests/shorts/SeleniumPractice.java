package com.cydeo.tests.shorts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement agreeCoockie = driver.findElement(By.id("L2AGLb"));
        agreeCoockie.click();
        Thread.sleep(3000);

        /*WebElement feelingButton = driver.findElement(By.name("btnI"));*/
        /*WebElement feelingButton = driver.findElement(By.className("RNmpXc"));*/
        /*WebElement feelingButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[2]"));*/
        WebElement feelingButton = driver.findElement(By.xpath("//*[@name='btnI'][2]"));
        /*WebElement feelingButton = driver.findElement(By.xpath("//input[@class='RNNXgb']"));*/
        feelingButton.click();
    }

}
