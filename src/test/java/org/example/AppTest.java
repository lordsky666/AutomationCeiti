package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.Driver; // your Driver class from before
import pom.FormPom;   // your Page Object

public class AppTest {

    WebDriver driver;

    static public String URL = "https://demoqa.com/automation-practice-form";
    static public String USER_NAME = "Robert";
    static public String USER_SURNAME = "Avram";
    static public String USER_EMAIL = "avramrobert06@gmail.com";
    static public String USER_GENDER = "Male";
    static public String USER_DOB = "06 June,2006";
    static public String USER_NUMBER = "0123456789";
    static public String USER_SUBJECT = "History";
    static public String USER_HOBBY = "Sports";
    static public String USER_ADDRESS = "Botanica veche 123";
    static public String USER_STATE = "Haryana";
    static public String USER_CITY = "Karnal";

    @BeforeClass
    public void setUp() {
        driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillFormTest() throws InterruptedException {
        driver.get(URL);

        // Fill the form

        FormPom form = new FormPom(driver);
        form.setFirstName(USER_NAME);
        form.setLastName(USER_SURNAME);
        form.closeAdvert();
        form.setUserEmail(USER_EMAIL);
        form.scrollToFirstName();
        form.setUserGender(USER_GENDER);
        form.setUserNumber(USER_NUMBER);
        form.scrollToDOB();
        form.setUserDOB(USER_DOB);
        form.setUserSubject(USER_SUBJECT);
        form.setUserHobby(USER_HOBBY);
        form.setUserAddress(USER_ADDRESS);
        form.setUserState(USER_STATE);
        form.setUserCity(USER_CITY);
        form.clickSubmit();

        // Compare results

        Thread.sleep(1000);

        String fullName = driver.findElement(By.xpath("//tbody//tr[1]/*[2]")).getText();
        Assert.assertEquals(fullName, (USER_NAME + " " + USER_SURNAME));

        String email = driver.findElement(By.xpath("//tbody//tr[2]/*[2]")).getText();
        Assert.assertEquals(email, USER_EMAIL);

        String gender = driver.findElement(By.xpath("//tbody//tr[3]/*[2]")).getText();
        Assert.assertEquals(gender, USER_GENDER);

        String number = driver.findElement(By.xpath("//tbody//tr[4]/*[2]")).getText();
        Assert.assertEquals(number, USER_NUMBER);

        String dateOfBirth = driver.findElement(By.xpath("//tbody//tr[5]/*[2]")).getText();
        Assert.assertEquals(dateOfBirth, USER_DOB);

        String subject = driver.findElement(By.xpath("//tbody//tr[6]/*[2]")).getText();
        Assert.assertEquals(subject, USER_SUBJECT);

        String hobby = driver.findElement(By.xpath("//tbody//tr[7]/*[2]")).getText();
        Assert.assertEquals(hobby, USER_HOBBY);

        String address = driver.findElement(By.xpath("//tbody//tr[9]/*[2]")).getText();
        Assert.assertEquals(address, USER_ADDRESS);

        String stateCity = driver.findElement(By.xpath("//tbody//tr[10]/*[2]")).getText();
        Assert.assertEquals(stateCity, USER_STATE + " " + USER_CITY);

        System.out.println();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}