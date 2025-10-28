package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.FormPom;

public class FormTest {

    WebDriver driver;
    static public String URL = "https://demoqa.com/automation-practice-form";  // replace with your test URL
    static public String USER_NAME = "Daniil";

    @BeforeClass
    public void beforeTest() {
        driver = Driver.getLocalDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillFormTest() {
        driver.get(URL);
        FormPom form = new FormPom(driver);
        form.setFirstName(USER_NAME);
        // You could add more form fields & actions later
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}