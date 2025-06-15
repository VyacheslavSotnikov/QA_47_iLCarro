package ui_tests;

import dto.Car;
import dto.UserLombok;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetCarWorkPage;
import pages.LoginPage;
import utils.HeaderMenuItem;

import static pages.BasePage.*;
import static utils.RandomUtils.*;

public class AddNewCarTests extends ApplicationManager {

    LoginPage loginPage;
    LetCarWorkPage letCarWorkPage;

    @BeforeMethod
    public void login(){
        HomePage homePage = new HomePage(getDriver());
        loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);

        UserLombok user = UserLombok.builder()
                .username("bilbo_baggins_12345@mail.com")
                .password("Password123!")
                .build();

        loginPage.typeLoginForm(user);

        letCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel("Gas")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
    }
}