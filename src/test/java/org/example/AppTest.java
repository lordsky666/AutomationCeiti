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
    static public String URL = "https://demoqa.com/automation-practice-form"; // replace with your URL
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
        driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillFormTest() throws InterruptedException {
        driver.get(URL);
        FormPom form = new FormPom(driver);
        form.setFirstName(USER_NAME);
        form.setLastName(USER_SURNAME);
        form.setEmail(USER_EMAIL);
        form.closeAdvert();
        form.scrollToFirstName();
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
        System.out.printf("");


        Thread.sleep(1000);

        String fullName = driver.findElement(By.xpath("//tbody//tr[1]/*[2]")).getText();
        Assert.assertEquals(fullName, (USER_NAME + " " + USER_SURNAME));

        String email = driver.findElement(By.xpath("//tbody//tr[2]/*[2]")).getText();
        Assert.assertEquals(email, USER_EMAIL);

        String gender = driver.findElement(By.xpath("//tbody//tr[3]/*[2]")).getText();
        Assert.assertEquals(gender, USER_GENDER);

        String number = driver.findElement(By.xpath("//tbody//tr[4]/*[2]")).getText();
        Assert.assertEquals(number, NUMBER);

        String dateOfBirth = driver.findElement(By.xpath("//tbody//tr[5]/*[2]")).getText();
        Assert.assertEquals(dateOfBirth, DATE);

        String subject = driver.findElement(By.xpath("//tbody//tr[6]/*[2]")).getText();
        Assert.assertEquals(subject, USER_SUBJECT);

        String hobby = driver.findElement(By.xpath("//tbody//tr[7]/*[2]")).getText();
        Assert.assertEquals(hobby, USER_HOBBY);

        String address = driver.findElement(By.xpath("//tbody//tr[9]/*[2]")).getText();
        Assert.assertEquals(address, USER_ADRESS);

        String stateCity = driver.findElement(By.xpath("//tbody//tr[10]/*[2]")).getText();
        Assert.assertEquals(stateCity, USER_STATE + " " + USER_CITY);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}