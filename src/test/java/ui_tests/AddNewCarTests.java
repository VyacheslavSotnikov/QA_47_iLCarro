package ui_tests;

import data_provider.CarDP;
import dto.Car;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetCarWorkPage;
import pages.LoginPage;
import utils.Fuel;
import utils.HeaderMenuItem;
import utils.TestNGListener;

import java.util.List;

import static pages.BasePage.*;
import static utils.RandomUtils.*;

@Listeners(TestNGListener.class)
public class AddNewCarTests extends ApplicationManager {

    LoginPage loginPage;
    LetCarWorkPage letCarWorkPage;

    @BeforeMethod
    public void login() {
        new HomePage(getDriver());
        loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm("bilbo_baggins_12345@mail.com", "Password123!");
        letCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest() {
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-" + generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
    }

    @Test(dataProvider = "addNewCarDP", dataProviderClass = CarDP.class)
    public void addNewCarPositiveTestDP(Car car) {
        letCarWorkPage.typeAddNewCarForm(car);
    }

    @Test(dataProvider = "addNewCarDPFile", dataProviderClass = CarDP.class)
    public void addNewCarNegativeTest(Car car) {
        logger.info("test data --> " + car);
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertFalse(letCarWorkPage.isEnabledSubmitBtn());
    }

    @Test(dataProvider = "addNewCarDPOnlyForEmptyCity", dataProviderClass = CarDP.class)
    public void addNewCarNegativeTest_EmptyCity(Car car) {
        letCarWorkPage.typeAddNewCarFormEmptyLoc(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Wrong address"));
    }

    @Test(dataProvider = "addNewCarDPForNegativeTests", dataProviderClass = CarDP.class)
    public void addNewCarNegativeTest_AllNegative(Car car) {
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertFalse(letCarWorkPage.isEnabledSubmitBtn());
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Make is required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Model is required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Year required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Fuel is required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Number of seats is required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Car class is required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Car registration number is required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Price is required"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Wrong year"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("To much seats"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Car must have min 2 seat"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("To long car registration number"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Price must be positive"));
//        Assert.assertTrue(letCarWorkPage.validateErrorMessage("To much big price"));
        }
}

