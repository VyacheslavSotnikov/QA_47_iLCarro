package pages;

import dto.Car;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class LetCarWorkPage extends BasePage{
    public LetCarWorkPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "pickUpPlace")
    WebElement inputCity;

    @FindBy(id = "make")
    WebElement inputManufacture;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(id = "fuel")
    WebElement selectFuel;
    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputCarClass;
    @FindBy(id = "serialNumber")
    WebElement inputSerialNumber;
    @FindBy(id = "price")
    WebElement inputPrice;

    @FindBy(xpath = "//div[@class='pac-container']//button")
    WebElement googleMapsBtnOk;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    public void typeAddNewCarForm(Car car) {
        inputCity.sendKeys(car.getCity());
        googleMapsBtnOk.click();
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        selectFuel.sendKeys(car.getFuel()); //!!!!!!!!!!!!!!!!!!! class select
        if (car.getSeats() != null) {
            inputSeats.sendKeys(car.getSeats().toString());
        } else {
            inputSeats.click();
        }
        inputCarClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        if (car.getPricePerDay() != null) {
            inputPrice.sendKeys(car.getPricePerDay().toString());
        } else {
            inputPrice.click();
        }
        btnSubmit.click();
    }

    public void typeAddNewCarFormEmptyLoc(Car car) {
        inputCity.sendKeys(car.getCity());
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        selectFuel.sendKeys(car.getFuel()); //!!!!!!!!!!!!!!!!!!! class select
        if (car.getSeats() != null) {
            inputSeats.sendKeys(car.getSeats().toString());
        } else {
            inputSeats.click();
        }
        inputCarClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        if (car.getPricePerDay() != null) {
            inputPrice.sendKeys(car.getPricePerDay().toString());
        } else {
            inputPrice.click();
        }
        btnSubmit.click();
    }
}