package pages;

import dto.UserLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Y’alla!']")
    WebElement btnYalla;

    @FindBy(xpath = "//div[text()=' Password is required ']")
    WebElement messageErrorPassword;

    @FindBy(xpath = "//div[text()=' Email is required ']")
    WebElement messageErrorEmptyEmail;

    @FindBy(xpath = "//div[contains(text(), 'email')]")
    WebElement messageErrorIncorrectEmail;


    public void typeLoginForm(UserLombok user){
        logger.info("type login form with data " + user.toString());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        logger.info("click btn login 'Yalla' " + btnYalla.getTagName());
        btnYalla.click();
    }

    public boolean validateMessageErrorEmptyPassword(){
        return isElementPresent(messageErrorPassword);
    }

    public boolean validateMessageErrorEmptyEmail(){
        return isElementPresent(messageErrorEmptyEmail);
    }

    public boolean validateMessageErrorIncorrectEmail(){
        return isElementPresent(messageErrorIncorrectEmail);
    }
}
