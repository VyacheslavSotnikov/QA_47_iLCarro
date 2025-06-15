package pages;

import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HeaderMenuItem;

public abstract class BasePage {

    @Setter
    static WebDriver driver;
    Logger logger = LoggerFactory.getLogger(BasePage.class);

    @FindBy(xpath = "//div[@class='dialog-container']")
    WebElement popUpMessage;

    public boolean validatePopUpMessage(String text){
        return isTextInElementPresent(popUpMessage, text);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends BasePage> T clickButtonsOnHeader(HeaderMenuItem headerMenuItem){
        WebElement element = driver.findElement(By.xpath(headerMenuItem.getLocator()));
        element.click();
        switch (headerMenuItem){
            case LOGIN -> {return (T) new LoginPage(driver);}
            case SEARCH -> {return (T) new HomePage(driver);}
            case SIGN_UP -> {return (T) new SignUpPage(driver);}
            case TERMS -> {return (T) new TermOfUseTerms(driver);}
            case LET_CAR_WORK -> {return (T) new LetCarWorkPage(driver);}
            default -> throw new IllegalArgumentException("Invalid parameter headerMenuItem");
        }
        // return (T) new HomePage_PB(driver);
    }

    public boolean isTextInElementPresent(WebElement element, String text){
       return element.getText().contains(text);
    }

    public boolean isElementPresent(WebElement element){
        return element.isDisplayed();
    }

    public boolean elementIsEnabled(WebElement element){
        return element.isEnabled();
    }
}
