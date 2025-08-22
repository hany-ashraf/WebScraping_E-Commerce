package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.time.Duration;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static util.Utility.openBrowserNetworkTab;

public class TestBase {
    @Parameters({"browser","URL"})
    @BeforeTest
    public void setupDriver(@Optional String browser, String URL) throws AWTException {
        if(browser == null) browser = "";
        setDriver(getNewInstance(browser));
        getDriver().get(URL);
        //TODO: Open network tap to monitor APIs
        //openBrowserNetworkTab();
    }

    //TODO: Back again to the home page
    public void clickBack(){
        getDriver().navigate().back();
    }

    //TODO: Refresh the page
    public void clickRefreshTwice(){
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
    }

    //TODO: Implicit Waiting
    public void waitToLoadElement(WebElement locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(
                ExpectedConditions.visibilityOf(locator)
        );
    }

    @AfterTest
    public void tearDown(){
        getDriver().quit();
    }

}
