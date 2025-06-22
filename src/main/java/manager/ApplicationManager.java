package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;

import java.time.Duration;
import java.time.LocalDate;

public class ApplicationManager {
    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    @BeforeMethod
    public void setup(){
        //logger.info("Start testing "+ LocalDate.now() +" ============================");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //new realization WDListener in Selenium4
        WebDriverListener webDriverListener = new WDListener();
        driver = new EventFiringDecorator<>(webDriverListener).decorate(driver);

    }

    @AfterMethod
    public void tearDown(){
        //if(driver != null)
        //driver.quit();
    }
}
