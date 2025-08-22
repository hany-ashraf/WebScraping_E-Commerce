package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_SwagLabsLoginPage extends BasePage{

    //Create constructor for initialization
    public P01_SwagLabsLoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By homePageTitle = By.xpath("(//div[@class=\"product_label\"])[1]");
    private final By failureMessage = By.xpath("//h3[@data-test=\"error\"]");

    //Action Methods
    public P01_SwagLabsLoginPage fillUserName(String userName){
        driver.findElement(this.userName).sendKeys(userName);
        return this;
    }
    public P01_SwagLabsLoginPage fillPassword(String password){
        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public P01_SwagLabsLoginPage clickLoginButton(){
        driver.findElement(this.loginButton).click();
        return this;
    }
    public boolean isHomeTitlePageShown(String message){
        return message.equals(driver.findElement(homePageTitle).getText());
    }
    public boolean isLoginFailureShown(String message){
        return message.equals(driver.findElement(failureMessage).getText());
    }


}
