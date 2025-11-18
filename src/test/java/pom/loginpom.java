
package org.example.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpom {

    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = "//*[@id='userName']")
    WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login']")
    WebElement login;

    public loginpom(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }


    public void setPassword(String passParam) {
        password.clear();
        password.sendKeys(passParam);
    }

    public void setUserName(String userNameParam) {
        userName.clear();
        userName.sendKeys(userNameParam);
    }
}



