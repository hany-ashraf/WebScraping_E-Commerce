package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class P02_SwagLabsHomePage extends BasePage {

    //Create constructor for initialization
    public P02_SwagLabsHomePage(WebDriver driver) {
        super(driver);
    }

    //Locator
    private final By title = By.xpath("(//div/a/div[@class=\"inventory_item_name\"])[1]");
    private final By productDescription = By.xpath("(//div/a/following-sibling::div)[1]");
    private final By price = By.xpath("(//div/div[@class=\"inventory_item_price\"])[1]");

    //Action methods
    //index: number of products in home page
    public ArrayList<String[]> getDetailsOfProduct(int index){
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            String name = driver.findElement(By.xpath("(//div/a/div[@class=\"inventory_item_name\"])[" + (i + 1) + "]")).getText();
            String desc = driver.findElement(By.xpath("(//div/a/following-sibling::div)[" + (i + 1) + "]")).getText();
            String price = driver.findElement(By.xpath("(//div/div[@class=\"inventory_item_price\"])[" + (i + 1) + "]")).getText();

            // Instead of concatenating, put them as separate columns
            list.add(new String[]{name, desc, price});
        }
        return list;
    }




}
