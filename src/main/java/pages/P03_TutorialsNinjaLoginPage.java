package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P03_TutorialsNinjaLoginPage extends BasePage{

    //Create constructor for initialization
    public P03_TutorialsNinjaLoginPage(WebDriver driver) {
        super(driver);
    }

    // Locate elements
    private final By firstName = By.xpath("(//div/input)[2]");
    private final By lastName = By.xpath("(//div/input)[3]");
    private final By email = By.xpath("(//div/input)[4]");
    private final By telephone = By.xpath("(//div/input)[5]");
    private final By password = By.xpath("(//div/input)[6]");
    private final By passwordConfirm = By.xpath("(//div/input)[7]");
    private final By subscribeSelect = By.xpath("(//div/label/input)[3]");
    private final By policyChecked = By.xpath("(//div/input)[8]");
    private final By continueButton = By.xpath("(//div/input)[9]");
    private final By myAccount = By.xpath("//li/a[@title=\"My Account\"]");
    private final By registerButton = By.xpath("//ul/li/a[text()=\"Register\"]");
    private final By returnHomePageButton = By.xpath("//ul/li/a/i[@class=\"fa fa-home\"]");

    //Action Methods
    public void registerNewAccount(
            String firstName,
            String lastName,
            String email,
            String telephone,
            String password
    ){
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.telephone).sendKeys(telephone);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.passwordConfirm).sendKeys(password);

    }
    public void selectUnsubscribe() {

        driver.findElement(this.subscribeSelect).click();
    }

    public void agreeToPolicy() {

        driver.findElement(this.policyChecked).click();
    }

    public void clickContinue() {

        driver.findElement(this.continueButton).click();
    }
    public void clickMyAccount(){
        driver.findElement(this.myAccount).click();
    }
    public void clickRegister(){

        driver.findElement(this.registerButton).click();
    }
    public void clickReturnHomePage(){
        driver.findElement(this.returnHomePageButton).click();
    }
}
