package ui_tests;

import dto.UserLombok;
import manager.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.validatePopUpMessage("Registered"));
    }

    @Test
    public void signUpNegativeTest_WOcheckbox(){
        UserLombok user = UserLombok.builder()
                .firstName("")
                .lastName("Baggins")
                .username(generateEmail(7))
                .password("Password123!")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickCheckBox();
        signUpPage.clickBtnYalla();
        Assert.assertFalse(signUpPage.btnYallaIsEnabled());
    }

    @Test
    public void signUpNegativeTest_WOname(){
        UserLombok user = UserLombok.builder()
                .firstName("")
                .lastName("Baggins")
                .username(generateEmail(7))
                .password("Password123!")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.validateErrorMessage("Name is required"));
    }

    @Test
    public void signUpNegativeTest_WOlastName(){
        UserLombok user = UserLombok.builder()
                .firstName("Bilbo")
                .lastName("")
                .username(generateEmail(7))
                .password("Password123!")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.validateErrorMessage("Last name is required"));
    }

    @Test
    public void signUpNegativeTest_WOEmail(){
        UserLombok user = UserLombok.builder()
                .firstName("Bilbo")
                .lastName("Baggins")
                .username("")
                .password("Password123!")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.validateErrorMessage("Email is required"));
    }

    @Test
    public void signUpNegativeTest_WOpassword(){
        UserLombok user = UserLombok.builder()
                .firstName("Bilbo")
                .lastName("Baggins")
                .username(generateEmail(7))
                .password("")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.validateErrorMessage("Password is required"));
    }

    @Test
    public void signUpNegativeTest_WrongEmail(){
        UserLombok user = UserLombok.builder()
                .firstName("Bilbo")
                .lastName("Baggins")
                .username("wwwww")
                .password("Password123!")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.validateErrorMessage("Wrong email format"));
    }

    @Test
    public void signUpNegativeTest_WrongPassword(){
        UserLombok user = UserLombok.builder()
                .firstName("Bilbo")
                .lastName("Baggins")
                .username(generateEmail(7))
                .password("frfrfrfrf")
                .build();
        signUpPage.typeSignUpForm(user);
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.validateErrorMessage("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));
    }
}
