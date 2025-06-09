package ui_tests;

import dto.UserLombok;
import  static  utils.RandomUtils.*;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTests extends ApplicationManager {

    private RegistrationPage registrationPage;

    @BeforeMethod
    private void goToSignUpPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnSignUpHeader();
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void registrationPositiveTest() {
        registrationPage.typeRegistrationForm("r", "g", "sotiga2031@mail.ru", "@Bilbo1234");
    }

    @Test
    public void registrationPositiveTest_lombok() {
        UserLombok user = UserLombok.builder()
                .firstName("u")
                .lastName("y")
                .username(generateEmail(7))
                .password("Bilbo12345@")
                .build();
        registrationPage.typeRegistrationForm(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        Assert.assertTrue(registrationPage.validatePopUpMessageReg("You are logged in success"), "registrationPositiveTest_lombok");
    }

    @Test
    public void registrationNegativeTest_EmptyNameReg() {
        UserLombok user = UserLombok.builder()
                .firstName("")
                .lastName("y")
                .username(generateEmail(7))
                .password("Bilbo12345@")
                .build();
        registrationPage.typeRegistrationForm(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        Assert.assertTrue(registrationPage.validateMessageErrorEmptyNameReg(), "registrationNegativeTest_EmptyNameReg");
    }

    @Test
    public void registrationNegativeTest_EmptyLastNameReg() {
        UserLombok user = UserLombok.builder()
                .firstName("slava")
                .lastName("")
                .username(generateEmail(7))
                .password("Bilbo12345@")
                .build();
        registrationPage.typeRegistrationForm(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        Assert.assertTrue(registrationPage.validateMessageErrorEmptyLastNameReg(), "registrationNegativeTest_EmptyLastNameReg");
    }

    @Test
    public void registrationNegativeTest_EmptyEmailReg() {
        UserLombok user = UserLombok.builder()
                .firstName("petya")
                .lastName("sodorov")
                .username("")
                .password("Bilbo12345@")
                .build();
        registrationPage.typeRegistrationForm(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        Assert.assertTrue(registrationPage.validateMessageErrorEmptyEmailReg(), "registrationNegativeTest_EmptyEmailReg");
    }

    @Test
    public void registrationNegativeTest_EmptyPasswordReg() {
        UserLombok user = UserLombok.builder()
                .firstName("petya")
                .lastName("sodorov")
                .username(generateEmail(8))
                .password("")
                .build();
        registrationPage.typeRegistrationForm(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        Assert.assertTrue(registrationPage.validateMessageErrorEmptyPasswordReg(), "registrationNegativeTest_EmptyPasswordReg");
    }

    @Test
    public void registrationNegativeTest_WrongEmailReg() {
        UserLombok user = UserLombok.builder()
                .firstName("petya")
                .lastName("sodorov")
                .username("sotigmail.com")
                .password("@Bilbo12345")
                .build();
        registrationPage.typeRegistrationForm(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        Assert.assertTrue(registrationPage.validateMessageErrorWrongEmailReg(), "registrationNegativeTest_WrongEmailReg");
    }

    @Test
    public void registrationNegativeTest_WrongPasswordReg() {
        UserLombok user = UserLombok.builder()
                .firstName("petya")
                .lastName("sodorov")
                .username("sotigmail.com")
                .password("1")
                .build();
        registrationPage.typeRegistrationForm(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());
        Assert.assertTrue(registrationPage.validateMessageErrorWrongPasswordReg(), "validateMessageErrorWrongPasswordReg");
    }
}
