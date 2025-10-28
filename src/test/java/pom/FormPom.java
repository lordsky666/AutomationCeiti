package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPom {

    WebDriver driver;
    JavascriptExecutor js;


    @FindBy(xpath = "//*[@id='firstName']")  // example, replace with your element’s xpath
    WebElement firstName;
    @FindBy(xpath = "//*[@id='lastName']")  // example, replace with your element’s xpath
    WebElement lastName;
    @FindBy(xpath = "//*[@id='userEmail']")  // example, replace with your element’s xpath
    WebElement userEmail;
    @FindBy(xpath = "//*[@id='userNumber']")  // example, replace with your element’s xpath
    WebElement userNumber;
    @FindBy(xpath = "//*[@id='dateOfBirthInput']")  // example, replace with your element’s xpath
    WebElement dateOfBirthInput;
    @FindBy(xpath = "//*[@id='subjectsInput']")  // example, replace with your element’s xpath
    WebElement subjectsInput;
    @FindBy(xpath = "//*[@id='state']")  // example, replace with your element’s xpath
    WebElement state;
    @FindBy(xpath = "//*[@id='city']")  // example, replace with your element’s xpath
    WebElement city;

    public FormPom(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstNameParam) {
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }

    public void setLastName(String lastNameParam){
        lastName.clear();
        lastName.sendKeys(lastNameParam);

    }

    public void setEmail(String EmailParam){
        userEmail.clear();
        userEmail.sendKeys(EmailParam);
    }

    public void setGender(String genderParam){
        WebElement gender = driver.findElement(By.xpath("//*[text() ='" + genderParam + "']"));
        gender.click();
    }

    public void setNumber(String numberParam){
        userNumber.clear();
        userNumber.sendKeys(numberParam);
    }

    public void setDateOfBirthInput(String dateOfBirthInputp){
        dateOfBirthInput.sendKeys(Keys.COMMAND,"a");
        dateOfBirthInput.sendKeys(dateOfBirthInputp);
        dateOfBirthInput.sendKeys(Keys.ENTER);

    }

    public void setHobby(String hobbyParam){
        WebElement hobby = driver.findElement(By.xpath("//*[text() ='" + hobbyParam + "']"));
        hobby.click();
    }

    public void setSubject(String SubjectParam) throws InterruptedException {
        subjectsInput.sendKeys(SubjectParam);
        Thread.sleep(1000);
        subjectsInput.sendKeys(Keys.TAB);
        System.out.println();
    }


    public void setState(String StateParam){
        state.click();
        driver.findElement(By.xpath("//*text()='" + StateParam + "']"));
    }

    public void setCity(String CityParam){
        city.click();
        driver.findElement(By.xpath("//*text()='" + CityParam + "']"));
    }

    public void scrollToDateOfBirth(){
        scrollToElement(dateOfBirthInput);
    }

    public void scrollToFirstName(){
        scrollToElement(firstName);
    }


    public void closeAdvert() {
        try {
            js.executeScript("var elem = document.evaluate(\"//*[@id='adplus-anchor']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
        try {
            js.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}