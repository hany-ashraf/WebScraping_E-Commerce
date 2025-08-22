package testcases;

import org.testng.annotations.Test;

import static util.CSVComparerAutoDetect.compareLatestTwoBySource;

public class TC03_ComparePrices{
    String dir = "src/test/java/OutputData";

    @Test(priority = 1, description = "This methods to generate the changes in prices")
    public void checkChangesPrices_P(){
        // Compare last two SwagLabs files
        compareLatestTwoBySource(dir, "SwagLabs");

        // Compare last two TutorialsNinja files
        compareLatestTwoBySource(dir, "TutorialsNinja");    }

}
