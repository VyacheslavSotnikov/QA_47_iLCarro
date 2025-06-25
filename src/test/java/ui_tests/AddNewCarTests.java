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

import static pages.BasePage.*;
import static utils.RandomUtils.*;

@Listeners(TestNGListener.class)
public class AddNewCarTests extends ApplicationManager {

    LoginPage loginPage;
    LetCarWorkPage letCarWorkPage;

    @BeforeMethod
    public void login(){
        new HomePage(getDriver());
        loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm("bilbo_baggins_12345@mail.com", "Password123!");
        letCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
    }

    @Test(dataProvider = "addNewCarDP", dataProviderClass = CarDP.class)
    public void addNewCarPositiveTestDP(Car car){
        letCarWorkPage.typeAddNewCarForm(car);
    }

    @Test(dataProvider = "addNewCarDPFile", dataProviderClass = CarDP.class)
    public void addNewCarNegativeTest(Car car){
        logger.info("test data --> " + car);
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertFalse(letCarWorkPage.isEnabledSubmitBtn());
    }

    @Test
    public void addNewCarNegativeTest_EmptyCity(){
        Car car = Car.builder()
                .city("")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarFormEmptyLoc(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Wrong address"));
    }

    @Test
    public void addNewCarNegativeTest_EmptyManufacture(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("")
                .model("Astra")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Make is required"));
    }

    @Test
    public void addNewCarNegativeTest_EmptyModel(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("")
                .year("2020")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Model is required"));
    }
    @Test
    public void addNewCarNegativeTest_EmptyYear(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Year required"));
    }
    @Test
    public void addNewCarNegativeTest_EmptyFuel(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel("")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Fuel is required"));
    }
    @Test
    public void addNewCarNegativeTest_EmptySeats(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(null)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Number of seats is required"));
    }
    @Test
    public void addNewCarNegativeTest_EmptyCarClass(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Car class is required"));
    }

    @Test
    public void addNewCarNegativeTest_EmptyCarRegNum(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("")
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Car registration number is required"));
    }
    @Test
    public void addNewCarNegativeTest_EmptyPrice(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(null)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Price is required"));
    }
    @Test
    public void addNewCarNegativeTest_WrongYear(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2026")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Wrong year"));
    }
    @Test
    public void addNewCarNegativeTest_ToMuchSeats(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(21)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("To much seats"));
    }
    @Test
    public void addNewCarNegativeTest_MinSeats(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(1)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Car must have min 2 seat"));
    }
    @Test
    public void addNewCarNegativeTest_WrongCarRegNum(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("fggfgggggggggggq")
                .pricePerDay(100.77)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("To long car registration number"));
    }
    @Test
    public void addNewCarNegativeTest_NegativePrice(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(-1.0)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("Price must be positive"));
    }
    @Test
    public void addNewCarNegativeTest_ToMuchPrice(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Corsa")
                .year("2010")
                .fuel(Fuel.HYBRID.getValue())
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+generateString(7))
                .pricePerDay(1001.00)
                .about("about")
                .image("1.jpg")
                .build();
        letCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letCarWorkPage.validateErrorMessage("To much big price"));
    }
}
