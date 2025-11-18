package org.example;
import testng.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

    public static String URL = "https://demoqa.com/login";
    public static String USER_NAME = "Robert";
    public static String PASSWORD = "ROBERT1!";

    @Test
    public void LoginTest() throws InterruptedException {

        WebDriver driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        driver.findElement(By.id("userName")).sendKeys(USER_NAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login")).click();

        Thread.sleep(2000);

        String actualUser = driver.findElement(By.id("userName-value")).getText();

        Assert.assertEquals(actualUser, USER_NAME, "User logged in does NOT match!");

        driver.quit();
    }
}