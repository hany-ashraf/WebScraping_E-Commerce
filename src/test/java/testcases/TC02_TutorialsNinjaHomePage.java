package testcases;

import org.testng.annotations.Test;
import static drivers.DriverHolder.getDriver;
import static util.Utility.*;
import pages.P04_TutorialsNinjaHomePage;
import pages.P03_TutorialsNinjaLoginPage;
import java.util.ArrayList;

public class TC02_TutorialsNinjaHomePage extends TestBase{
    String firstName = "H7dffy";
    String lastName = "As6gsdf";
    String email = "Automa5fsdTer1@gmail.com";
    String password = "jhk0sdfs$358";
    String phone = "01245sfda1tv";


    @Test(priority = 1, description = "Register with valid data of new account")
    public void extractDataOfProductsFromTutorialsNinja_P() throws InterruptedException {
        new P03_TutorialsNinjaLoginPage(getDriver()).clickMyAccount();
        new P03_TutorialsNinjaLoginPage(getDriver()).clickRegister();
        new P03_TutorialsNinjaLoginPage(getDriver()).registerNewAccount(firstName,lastName,email,phone,password);
        new P03_TutorialsNinjaLoginPage(getDriver()).selectUnsubscribe();
        new P03_TutorialsNinjaLoginPage(getDriver()).agreeToPolicy();
        new P03_TutorialsNinjaLoginPage(getDriver()).clickContinue();
        Thread.sleep(3000);
        new P03_TutorialsNinjaLoginPage(getDriver()).clickReturnHomePage();
        ArrayList<String[]> products = new P04_TutorialsNinjaHomePage(getDriver()).getDetailsOfProducts();
        System.out.println(products);
        writeToCSV(products);

    }

}
