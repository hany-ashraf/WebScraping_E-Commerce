package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    //driver declaration
    WebDriver driver;

    //Create Constructor for driver initialization
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
