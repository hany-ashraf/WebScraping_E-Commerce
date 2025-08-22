package testcases;


import org.testng.annotations.Test;
import pages.P01_SwagLabsLoginPage;
import pages.P02_SwagLabsHomePage;
import java.util.ArrayList;
import static drivers.DriverHolder.getDriver;
import static util.Utility.writeToCSV;

public class TC01_SwagLabsHomePage extends TestBase{
    String userName = "standard_user";
    String password = "secret_sauce";

    @Test(priority = 1, description = "Login to SwagLab Wep App and extract data of product")
    public void extractDataOfProductsFromSwagLabs_P(){
        new P01_SwagLabsLoginPage(getDriver()).fillUserName(userName).fillPassword(password).clickLoginButton();
        //Assert.assertTrue(new P01_LoginPage(getDriver()).isHomeTitlePageShown(homePageMessage), "Home page title is not as expected");
        ArrayList<String[]> products = new P02_SwagLabsHomePage(getDriver()).getDetailsOfProduct(6);
        System.out.println(products);
        writeToCSV(products);

    }

}
