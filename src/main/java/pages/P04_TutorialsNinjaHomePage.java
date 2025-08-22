package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.Utility.extractFirstPrice;
import static util.Utility.extractNumberAfterTo;

public class P04_TutorialsNinjaHomePage extends BasePage {

    //Create constructor for initialization
    public P04_TutorialsNinjaHomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By noItems = By.xpath("//div/div/following-sibling::div[@class=\"col-sm-6 text-right\"]");
    private final By monitor = By.xpath("(//div[@class=\"col-sm-3\"]/ul/li/following-sibling::li/a)[1]");
    private final List<By> locators = Arrays.asList(
            By.xpath("//div/div/following-sibling::a[text()='Show AllDesktops']"),
            By.xpath("//div/div/following-sibling::a[text()='Show AllLaptops & Notebooks']"),
            By.xpath("//div/div/following-sibling::a[text()='Show AllComponents']")
            );
    private final By title = By.xpath("(//div/div/h4/a)[1]");
    private final By desc = By.xpath("(//div/div/h4/following-sibling::p)[1]");
    private final By price = By.xpath("(//div/div/h4/following-sibling::p/following-sibling::p[@class=\"price\"])[1]");

    public ArrayList<String[]> getDetailsOfProducts() throws InterruptedException {
        ArrayList<String[]> list = new ArrayList<>();
        int index = 1;
        int items = 0;
        String[] Category = {
                "Desktops",
                "Laptops & Notebooks",
                "Components",
                "MP3 Players"
        };
        while (index < 4){
            // Build the dynamic XPath
            String xpath = "//ul/li/a[text()=\"" + Category[index-1] + "\"]";
            // Find the element
            WebElement componentsCat = this.driver.findElement(By.xpath(xpath));
            // Instantiate Actions class
            Actions actions = new Actions(this.driver);
            // Hover over the element
            actions.moveToElement(componentsCat).perform();
            driver.findElement(locators.get(index-1)).click();
            Thread.sleep(2000);
            if(index<3) {
                 items = extractNumberAfterTo(driver.findElement(noItems).getText());
            }else{
                driver.findElement(monitor).click();
                items = extractNumberAfterTo(driver.findElement(noItems).getText());
            }
            int j = 0;
            int x = 0;
            do {
                Thread.sleep(5000);
                String title = driver.findElement(By.xpath("(//div/div/h4/a)[" + (j + 1) + "]")).getText();
                String desc = driver.findElement(By.xpath("(//div/div/h4/following-sibling::p)[" + (j + 1 + x) + "]")).getText();
                x=j+1;
                String price = extractFirstPrice(driver.findElement(By.xpath("(//div/div/h4/following-sibling::p/following-sibling::p[@class=\"price\"])[" + (j + 1) + "]")).getText());

                // Instead of concatenating, put them as separate columns
                list.add(new String[]{title, desc, price});

                j++;
            } while (j < items);

            index++;
        }
        return list;

    }


}
