package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.Driver;
import pom.FormPom;

public class AppTest {

    WebDriver driver;
    static public String URL = "https://demoqa.com/automation-practice-form";
    static public String USER_NAME = "Robert";
    static public String USER_SURNAME = "Avram";
    static public String USER_EMAIL = "avramrobert2060@gmail.com";
    static public String USER_GENDER = "Male";
    static public String DATE = "21 January,2005";
    static public String NUMBER = "0790280100";
    static public String USER_HOBBY = "Sports";
    static public String USER_SUBJECT = "Maths";
    static public String USER_STATE = "NCR";
    static public String USER_CITY = "Gurgaon";
    static public String USER_ADRESS = "Nigeria, Hamahan 17";

    @BeforeClass
    public void setUp() {
        driver = Driver.getLocalDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void fillFormTest() throws InterruptedException {
        FormPom form = new FormPom(driver);

        form.closeAdvert();
        form.scrollToFirstName();

        form.setFirstName(USER_NAME);
        form.setLastName(USER_SURNAME);
        form.setEmail(USER_EMAIL);
        form.setGender(USER_GENDER);
        form.setNumber(NUMBER);
        form.scrollToDateOfBirth();
        form.setDateOfBirthInput(DATE);
        form.setHobby(USER_HOBBY);
        form.setSubject(USER_SUBJECT);
        form.setAdress(USER_ADRESS);
        form.setState(USER_STATE);
        form.setCity(USER_CITY);
        form.setSubmit();

        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[1]/*[2]")).getText(),
                USER_NAME + " " + USER_SURNAME);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[2]/*[2]")).getText(),
                USER_EMAIL);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[3]/*[2]")).getText(),
                USER_GENDER);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[4]/*[2]")).getText(),
                NUMBER);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[5]/*[2]")).getText(),
                DATE);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[6]/*[2]")).getText(),
                USER_SUBJECT);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[7]/*[2]")).getText(),
                USER_HOBBY);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[9]/*[2]")).getText(),
                USER_ADRESS);
        Assert.assertEquals(driver.findElement(By.xpath("//tbody//tr[10]/*[2]")).getText(),
                USER_STATE + " " + USER_CITY);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}