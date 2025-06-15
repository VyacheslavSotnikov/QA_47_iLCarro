package ui_tests;

import dto.UserLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static utils.RandomUtils.*;

public class LoginTests extends ApplicationManager {

    private LoginPage loginPage;

    @BeforeMethod
    public void goToLoginPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void loginPositiveTest() {
        UserLombok user = UserLombok.builder()
                .username("sotiga2018@gmail.com")
                .password("Bilbo12345@")
                .build();
        loginPage.typeLoginForm(user);
    }

    @Test
    public void loginPositiveTest_lombok() {
        UserLombok user = UserLombok.builder()
                .username("sotiga2018@gmail.com")
                .password("Bilbo12345@")
                .build();
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.validatePopUpMessage("Logged in success"), "loginPositiveTest_lombok");
    }

    @Test
    public void loginNegativeTest_unregUser() {
        UserLombok user = UserLombok.builder()
                .username(generateEmail(10))
                .password("Bilbo12345@")
                .build();
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.validatePopUpMessage("Login or Password incorrect"), "loginNegativeTest_unregUser");
    }

    @Test
    public void loginNegativeTest_EmptyEmail() {
        UserLombok user = UserLombok.builder()
                .username("")
                .password("Bilbo12345@")
                .build();
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.validateMessageErrorEmptyEmail(), "loginNegativeTest_EmptyEmail");
    }

    @Test
    public void loginNegativeTest_EmptyPassword() {
        UserLombok user = UserLombok.builder()
                .username("sotiga2018@gmail.com")
                .password("")
                .build();
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.validateMessageErrorEmptyPassword(), "loginNegativeTest_EmptyPassword");
    }

    @Test
    public void loginNegativeTest_IncorrectEmail() {
        UserLombok user = UserLombok.builder()
                .username("sotiga2018gmail.com")
                .password("Bilbo12345@")
                .build();
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.validateMessageErrorIncorrectEmail(), "loginNegativeTest_IncorrectEmail");
    }

    @Test
    public void loginNegativeTest_IncorrectEmail2() {
        UserLombok user = UserLombok.builder()
                .username("sotiga2018@gmailcom")
                .password("Bilbo12345@")
                .build();
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.validatePopUpMessage("Login or Password incorrect"), "loginNegativeTest_unregUser");
    }
}
