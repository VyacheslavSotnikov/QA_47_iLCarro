package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends  BasePage{

    public RegistrationPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id="name")
    WebElement inputNameRegistration;

    @FindBy(id="lastName")
    WebElement inputLastNameRegistration;

    @FindBy(id="email")
    WebElement inputEmailRegistration;

    @FindBy(id="password")
    WebElement inputPasswordRegistration;

    @FindBy(xpath = "//label[@class='checkbox-label terms-label']")
   WebElement checkBoxRegistration;

    @FindBy(xpath = "//button[text()='Y’alla!']")
    WebElement btnYallaRegistration;

    @FindBy(xpath = "//div[@class='dialog-container']")
    WebElement popUpMessageRegistration;

    @FindBy(xpath = "//div[text()=' Name is required ']")
    WebElement messageErrorNameRegistration;

    @FindBy(xpath = "//div[text()=' Last name is required ']")
    WebElement messageErrorLastNameRegistration;

    @FindBy(xpath = "//div[text()='Email is required']")
    WebElement messageErrorEmailRegistration;

    @FindBy(xpath = "//div[text()='Password is required']")
    WebElement messageErrorPasswordRegistration;

    @FindBy(xpath = "//div[text()='Wrong email format']")
    WebElement messageErrorWrongEmailRegistration;

    @FindBy(xpath = "//div[text()='Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]']")
    WebElement messageErrorWrongPassportRegistration;

    public void typeRegistrationForm(String name, String lastName, String email, String password){
        inputNameRegistration.sendKeys(name);
        inputLastNameRegistration.sendKeys(lastName);
        inputEmailRegistration.sendKeys(email);
        inputPasswordRegistration.sendKeys(password);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBoxRegistration);
        btnYallaRegistration.click();
    }

    public boolean validatePopUpMessageReg(String text){
        return isTextInElementPresent(popUpMessageRegistration, text );
    }

    public boolean validateMessageErrorEmptyNameReg(){
        return isElementPresent(messageErrorNameRegistration);
    }

    public boolean validateMessageErrorEmptyLastNameReg(){
        return isElementPresent(messageErrorLastNameRegistration);
    }

    public boolean validateMessageErrorEmptyEmailReg(){
        return isElementPresent(messageErrorEmailRegistration);
    }

    public boolean validateMessageErrorEmptyPasswordReg(){
        return isElementPresent(messageErrorPasswordRegistration);
    }

    public boolean validateMessageErrorWrongEmailReg(){
        return isElementPresent(messageErrorWrongEmailRegistration);
    }

    public boolean validateMessageErrorWrongPasswordReg(){
        return isElementPresent(messageErrorWrongPassportRegistration);
    }
}
