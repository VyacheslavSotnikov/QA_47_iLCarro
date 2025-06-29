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
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "email")
    WebElement inputEmail;   // = driver.findElement(By.id("email"))

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Y’alla!']")
    WebElement btnYalla;

    @FindBy(xpath = "//div[text()=' Password is required ']")
    WebElement messageErrorPassword;

    public void typeLoginForm(UserLombok userLombok){
        inputEmail.sendKeys(userLombok.getUsername());
        inputPassword.sendKeys(userLombok.getPassword());
        btnYalla.click();
    }

    public boolean validateMessageErrorPassword(){
        return isElementPresent(messageErrorPassword);
    }
}