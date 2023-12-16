package com.cydeo.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CydeoPracticeUtils {

    public static String getOrderDate(WebDriver driver, String customerName) {
        var list = driver.findElements(By.xpath("//td[contains(text(), '" + customerName + "')]"));
        Assert.assertEquals(list.size(), 1);

        String actualOrderDate = list.get(0).findElement(By.xpath("following-sibling::td[3]")).getText();
        return actualOrderDate;
    }

    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate) {
        var list = driver.findElements(By.xpath("//td[contains(text(), '" + customerName + "')]"));
        Assert.assertEquals(list.size(), 1);

        String actualOrderDate = list.get(0).findElement(By.xpath("following-sibling::td[3]")).getText();
        Assert.assertEquals(actualOrderDate, expectedOrderDate);
    }

    public static String getTableGetEmail(WebDriver driver, int tableNum, String firstName) {
        var name = driver.findElement(
                By.xpath("//table['" + tableNum+ "']//td[@class='first-name' and text()='" + firstName + "']"));

        return name.findElement(
                By.xpath("following-sibling::td[1]")).getText();
    }
}
