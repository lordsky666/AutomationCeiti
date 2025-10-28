package org.example;

import org.openqa.selenium.WebDriver;
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
    static public String DATE = "21 Jan 2005";
    static public String NUMBER = "079028010";
    static public String USER_HOBBY = "Sports";
    static public String USER_SUBJECT = "Maths";
    static public String USER_STATE = "NCR";
    static public String USER_CITY = "Gurgaon";
    static public String USER_ADRESS = "Nigeria, Hamahan 17";


    @BeforeClass
    public void setUp() {
        driver = Driver.getLocalDriver();
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
        form.setState(USER_STATE);
        form.setCity(USER_CITY);
        System.out.printf("");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}