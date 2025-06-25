package pages;

import dto.Car;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Fuel;

import java.io.File;

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

    @FindBy(xpath = "//input[@type='file']")
    WebElement inputFile;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;


    public void typeAddNewCarForm(Car car) {
        inputCity.sendKeys(car.getCity());
        // googleMapsBtnOk.click();
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
//        selectFuel.sendKeys(car.getFuel()); //!!!!!!!!!!!!!!!!!!! class select
        typeFuel(car.getFuel());
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
        //addPhoto(car.getImage());
        btnSubmit.click();
    }

    private void addPhoto(String fileName) {
      inputFile.sendKeys(new File("src/test/resources/photos" + File.separator + fileName).getAbsolutePath());
    }

    private void typeFuel(String fuel){
        Select select = new Select(selectFuel);
        select.selectByValue(fuel);
    }

    public boolean isEnabledSubmitBtn(){
        return  elementIsEnabled(btnSubmit);
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