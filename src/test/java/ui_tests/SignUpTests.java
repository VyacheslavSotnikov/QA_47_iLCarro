package ui_tests;

import dto.UserLombok;
import manager.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import utils.HeaderMenuItem;

import static pages.BasePage.*;
import static utils.RandomUtils.*;

public class SignUpTests extends ApplicationManager {

    HomePage homePage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToLoginPage(){
        new HomePage((getDriver()));
        signUpPage = clickButtonsOnHeader(HeaderMenuItem.SIGN_UP);
    }

    @Test
    public void signUpPositiveTest(){
        UserLombok user = UserLombok.builder()
                .firstName("Bilbo")
                .lastName("Baggins")
                .username(generateEmail(7))
                .password("Password123!")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickCheckBox();
    }
}
